package leetcode.algorithm.np_problems.medium.permutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: blueaken
 * Date: 2/19/16 12:40 PM
 */
public class Solution_LeetCode {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return result;
        }

        boolean[] used = new boolean[nums.length];
        ArrayList<Integer> item = new ArrayList<>();
        Arrays.sort(nums);
        rec(nums, 0, item, used, result);

        return result;
    }

    private static void rec(int[] nums, int index, ArrayList<Integer> item, boolean[] used,
                            List<List<Integer>> result){
        if (index == nums.length){
            result.add(new ArrayList<>(item));
            return;
        }

        for (int i=0; i<nums.length; i++){
            if (i>0 && used[i-1] && nums[i] == nums[i-1]) continue;
            if (!used[i]){
                item.add(nums[i]);
                used[i] = true;
                rec(nums, index + 1, item, used, result);
                used[i] = false;
                item.remove(item.size()-1);
            }
        }
    }

    public static void main (String[] args){
//        int[] test = {1,2,2};
        int[] test = {3,3,0,3};
//        int[] test = {-1,2,-1,2,1,-1,2,1};

        List<List<Integer>> result = permuteUnique(test);
        System.out.println(result);
    }
}
