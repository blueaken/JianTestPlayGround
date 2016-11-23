package ninechapter_algorithm.chapter1_strstr_to_search_problems.subsets.third;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author: blueaken
 * Date: 6/10/16 09:07
 */
public class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);
        rec(nums, result, new ArrayList<Integer>(), 0);
        return result;
    }

    private void rec(int[] nums, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int index) {

        result.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            rec(nums, result, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
