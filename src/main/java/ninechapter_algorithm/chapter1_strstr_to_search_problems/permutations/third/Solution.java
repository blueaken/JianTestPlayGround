package ninechapter_algorithm.chapter1_strstr_to_search_problems.permutations.third;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Author: blueaken
 * Date: 5/5/16 08:57
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

        //needed if the order is in the requirement
        Collections.sort(nums);
        rec(nums, result, new ArrayList<Integer>());
        return result;
    }

    private void rec(ArrayList<Integer> nums, ArrayList<ArrayList<Integer>> result,
                     ArrayList<Integer> list) {
        if (list.size() == nums.size()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (list.contains(nums.get(i))) {
                continue;
            }
            list.add(nums.get(i));
            rec(nums, result, list);
            list.remove(list.size() - 1);
        }
        return;
    }
}
