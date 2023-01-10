package lintcode.backtrack.subset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum_LE_39 {
    /**
     1.10.2023
     ref 东哥 post
     使用回溯框架 Subset Solution, 元素无重复可重选类型, backtrack 参数从 i 开始，而非i +1, 多一条树枝
     */
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, 0, target);
        return res;
    }

    private void backtrack(int[] candidates, int start, int target) {
        if (target <= 0) {
            if (target == 0) {
                res.add(new LinkedList<>(track));
            }
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            track.add(candidates[i]);
            backtrack(candidates, i, target - candidates[i]);
            track.removeLast();
        }
    }
}
