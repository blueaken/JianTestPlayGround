package leetcode.algorithm.np_problems.medium.subsetsII;

import java.util.*;

/**
 * Author: blueaken
 * Date: 2/17/16 2:09 PM
 */
public class Solution_Works_But_Not_Efficient {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        if (nums == null) return null;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        rec(nums, nums.length-1, result);
        return result;
    }

    private static void rec(int[] data, int index, List<List<Integer>> result){
        if (index == -1) {
            List<Integer> temp = new ArrayList<>();
            result.add(temp);
            return;
        }

        rec(data, index-1, result);
        int size = result.size();
        for (int i=0; i<size; i++){
            List<Integer> temp = new ArrayList<>(result.get(i));
            temp.add(data[index]);
            if (result.contains(temp)) continue; //avoid duplicates
            result.add(temp);
        }
    }

    public static void main (String[] args){
        int[] test = {1,2,2};

        List<List<Integer>> result = subsetsWithDup(test);
        System.out.println(result);
    }

}
