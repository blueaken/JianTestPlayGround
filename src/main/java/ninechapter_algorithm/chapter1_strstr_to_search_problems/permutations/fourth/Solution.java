package ninechapter_algorithm.chapter1_strstr_to_search_problems.permutations.fourth;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Author: blueaken
 * Date: 6/10/16 11:10
 */
public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (nums == null || nums.size() == 0) {
            return result;
        }

        Collections.sort(nums);
        helper(nums, result, new ArrayList<Integer>());
        return result;
    }

    private void helper(ArrayList<Integer> nums, ArrayList<ArrayList<Integer>> result,
                        ArrayList<Integer> list) {
        if (list.size() == nums.size()) {
            result.add(new ArrayList<>(list));
            return;  //affect time efficiency
        }

        for (int i = 0; i < nums.size(); i++) {
            if (list.contains(nums.get(i))) {
                continue;
            }
            list.add(nums.get(i));
            helper(nums, result, list);
            list.remove(list.size() - 1);
        }
    }
}
