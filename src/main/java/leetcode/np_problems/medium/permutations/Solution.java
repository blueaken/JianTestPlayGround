package leetcode.np_problems.medium.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 2/19/16 10:45 AM
 */
public class Solution {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return result;
        }

        List<Integer> item = new ArrayList<>();
        rec(nums, 0, new boolean[nums.length], item, result);
        return result;
    }

    private static void rec(int[] nums, int index, boolean[] used, List<Integer> item, List<List<Integer>> result){
        if (index == nums.length){
            result.add(new ArrayList<>(item));
            return;
        }

        for (int i=0; i< nums.length; i++){
            if (!used[i]){
                item.add(nums[i]);
                used[i] = true;
                rec(nums, index+1, used, item, result);
                used[i] = false;
                item.remove(item.size()-1);
            }
        }
    }

    public static void main (String[] args){
        int[] test = {1,2,3};

        List<List<Integer>> result = permute(test);
        System.out.println(result);
    }
}
