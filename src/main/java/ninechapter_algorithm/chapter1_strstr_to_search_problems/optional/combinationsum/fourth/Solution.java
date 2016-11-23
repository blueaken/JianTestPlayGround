package ninechapter_algorithm.chapter1_strstr_to_search_problems.optional.combinationsum.fourth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: blueaken
 * Date: 6/13/16 16:34
 */
public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }

        Arrays.sort(candidates);
        rec(result, candidates, target, new ArrayList<Integer>());
        return result;
    }

    private void rec(List<List<Integer>> result, int[] candidates, int target,
                     List<Integer> list) {
        if (target <= 0) {
            if (target == 0) {
                result.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            //avoid duplicates
            if (i != 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            //make sure ascending order
            if (list.size() > 0 && candidates[i] < list.get(list.size() - 1)) {
                continue;
            }
            list.add(candidates[i]);
            rec(result, candidates, target - candidates[i], list);
            list.remove(list.size() - 1);
        }
    }
}
