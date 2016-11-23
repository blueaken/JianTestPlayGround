package ninechapter_algorithm.chapter7_array_and_number.subarraysumcloset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Author: blueaken
 * Date: 4/28/16 10:51 AM
 */
public class Solution {
//    /**
//     * @param nums: A list of integers
//     * @return: A list of integers includes the index of the first number
//     *          and the index of the last number
//     */
//    public static int[] subarraySumClosest(int[] nums) {
//        // write your code here
//        int[] result = new int[2];
//        if (nums == null || nums.length == 0) {
//            return result;
//        }
//
//        int s[] = new int[nums.length];
//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//            s[i] = sum;
//        }
//        return result;
//    }

    public static void main(String[] args) {
        //int[] nums = {6,-4,-8,3,1,7};
        int[] nums = {-3, 1, 1, -3, 5};

        System.out.println(Arrays.toString(subarraySumClosest(nums)));
    }

//    public static ArrayList<Integer> subarraySumClosest(int[] nums) {
//        ArrayList<Integer> res = new ArrayList<Integer>();
//        if (nums.length==0) return res;
//
//        Element[] sums = new Element[nums.length+1];
//        sums[0] = new Element(0,-1);
//        int sum = 0;
//        for (int i=0;i<nums.length;i++){
//            sum += nums[i];
//            sums[i+1] = new Element(sum,i);
//        }
//
//        Arrays.sort(sums);
//        int min = Math.abs(sums[0].getValue() - sums[1].getValue());
//        int start =  Math.min(sums[0].getIndex(), sums[1].getIndex())+1;
//        int end = Math.max(sums[0].getIndex(), sums[1].getIndex());
//        for (int i=1;i<nums.length;i++){
//            int diff = Math.abs(sums[i].getValue() - sums[i+1].getValue());
//            if (diff<min){
//                min = diff;
//                start = Math.min(sums[i].getIndex(), sums[i+1].getIndex())+1;
//                end  = Math.max(sums[i].getIndex(), sums[i+1].getIndex());
//            }
//        }
//
//        res.add(start);
//        res.add(end);
//        return res;
//    }

    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public static int[] subarraySumClosest(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }

        int len = nums.length;
        if(len == 1) {
            res[0] = res[1] = 0;
            return res;
        }
        Pair[] sums = new Pair[len+1];
        int prev = 0;
        sums[0] = new Pair(0, 0);
        for (int i = 1; i <= len; i++) {
            sums[i] = new Pair(prev + nums[i-1], i);
            prev = sums[i].sum;
        }
        Arrays.sort(sums, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return a.sum - b.sum;
            }
        });
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= len; i++) {

            if (ans > sums[i].sum - sums[i-1].sum) {
                ans = sums[i].sum - sums[i-1].sum;
                int[] temp = new int[]{sums[i].index - 1, sums[i - 1].index - 1};
                Arrays.sort(temp);
                res[0] = temp[0] + 1;
                res[1] = temp[1];
            }
        }

        return res;
    }
}


class Pair {
    int sum;
    int index;
    public Pair(int s, int i) {
        sum = s;
        index = i;
    }
}

class Element implements Comparable<Element>{
    int val;
    int index;
    public Element(int v, int i){
        val = v;
        index = i;
    }

    public int compareTo(Element other){
        return this.val - other.val;
    }

    public int getIndex(){
        return index;
    }

    public int getValue(){
        return val;
    }
}
