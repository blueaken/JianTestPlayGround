package ninechapter_algorithm.chapter1_strstr_to_search_problems.subsets.second;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author: blueaken
 * Date: 3/31/16 3:16 PM
 */
public class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public static ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);
        rec(nums, result, new ArrayList<Integer>(), 0);
        return result;
    }

    private static void rec(int[]nums, ArrayList<ArrayList<Integer>> result,
                            ArrayList<Integer> list, int start) {
        result.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            rec(nums, result, list, i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] test = {1,2,3};
        System.out.println(subsets(test));
    }
}
