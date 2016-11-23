package ninechapter_algorithm.chapter1_strstr_to_search_problems.optional.combinationsum.third;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: blueaken
 * Date: 5/5/16 14:29
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
        rec(candidates, target, result, new ArrayList<Integer>(), 0);
        return result;
    }

    private void rec(int[] candidates, int target, List<List<Integer>> result,
                     List<Integer> list, int index) {
        if (target <= 0) {
            if (target == 0) {
                result.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            //avoid duplicates
            if (i != index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            //make sure the result is in order
            if (list.size() > 0 && candidates[i] < list.get(list.size() - 1)) {
                continue;
            }
            list.add(candidates[i]);
            rec(candidates, target - candidates[i], result, list, index);
            list.remove(list.size() - 1);
        }
    }
}
