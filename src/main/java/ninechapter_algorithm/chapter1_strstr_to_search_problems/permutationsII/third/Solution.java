package ninechapter_algorithm.chapter1_strstr_to_search_problems.permutationsII.third;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Author: blueaken
 * Date: 6/10/16 11:31
 */
public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (nums == null || nums.size() == 0) {
            return result;
        }

        boolean[] visited = new boolean[nums.size()];
        Collections.sort(nums);
        helper(nums, result, new ArrayList<Integer>(), visited, 0);
        return result;
    }

    private void helper(ArrayList<Integer> nums, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, boolean[] visited, int index) {
        if (list.size() == nums.size()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < nums.size(); i++) {
            if (visited[i] || i!=0 && nums.get(i) == nums.get(i-1) && visited[i-1]) {
                continue;
            }

            list.add(nums.get(i));
            visited[i] = true;
            helper(nums, result, list, visited, index);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
