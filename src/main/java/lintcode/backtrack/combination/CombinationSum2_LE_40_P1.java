package lintcode.backtrack.combination;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2_LE_40_P1 {
    /**
     1.9.2023
     ref 东哥 post
     回溯框架subset问题框架 + duplicate剪枝
     ================
     3.2.2023
     P1
     */

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(candidates, 0, target);
        return res;
    }

    private void backTrack(int[] candidates, int start, int target) {
        if (target <= 0) {
            if (target == 0) {
                res.add(new LinkedList<>(track));
            }
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // remove duplicates
            if (i > start && candidates[i] == candidates[i-1]) {
                continue;
            }

            track.add(candidates[i]);
            backTrack(candidates, i+1, target - candidates[i]);
            track.removeLast();
        }
    }
}
