package lintcode.backtrack.combination;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2_LE_40 {
    /**
     1.9.2023
     ref 东哥 post
     回溯框架subset问题框架 + duplicate剪枝
     */

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, target);
        return res;
    }

    private void backtrack(int[] candidates, int start, int target) {
        // base case
        if (target <= 0) {
            if (target == 0) {
                res.add(new LinkedList<>(track));
            }
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // duplicate 剪枝
            if (i > start && candidates[i] == candidates[i-1]) {
                continue;
            }

            track.add(candidates[i]);
            backtrack(candidates, i+1, target - candidates[i]);
            track.removeLast();
        }
    }
}
