package leetcode.np_problems.medium.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: blueaken
 * Date: 2/16/16 8:26 PM
 */
public class Solution {
    /*
       i tried with 2 loops but not working, it turns out to be a NP problem. using the
        following pattern to attack it.
     */
//    public static List<List<Integer>> subsets(int[] nums) {
//        if (nums == null) return null;
//        int len = nums.length;
//
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> temp = new ArrayList<>();
//        result.add(temp);
//        for (int i=0; i<len; i++){
//            temp = new ArrayList<>();
//            for (int j=i; j<len; j++){
//                temp.add(nums[j]);
//                result.add(new ArrayList<>(temp));
//            }
//        }
//        return result;
//    }

    public static List<List<Integer>> subsets(int[] num) {
        if(num == null)
            return null;
        Arrays.sort(num);  // make sure the result elements is of ascending order
        return helper(num, num.length-1);
    }

    private static List<List<Integer>> helper(int[] num, int index)
    {
        if(index == -1)
        {
            List<List<Integer>> res = new ArrayList<>();
            ArrayList<Integer> elem = new ArrayList<>();
            res.add(elem);
            return res;
        }
        List<List<Integer>> res = helper(num,index-1);
        int size = res.size();
        for(int i=0;i<size;i++)
        {
            ArrayList<Integer> elem = new ArrayList<>(res.get(i));
            elem.add(num[index]);
            res.add(elem);
        }
        return res;
    }

    public static void main (String[] args){
        int[] test = {1,2,3};

        List<List<Integer>> result = subsets(test);
        System.out.println(result);
    }
}
