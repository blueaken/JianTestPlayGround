package lintcode.backtrack.subset;

import java.util.LinkedList;
import java.util.List;

public class CombinationSum_LE_39_P1 {
    /**
     1.10.2023
     ref 东哥 post
     使用回溯框架 Subset Solution, 元素无重复可重选类型, backtrack 参数从 i 开始，而非i +1, 多一条树枝
     ===============
     3.2.2023
     P1
     */
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            track.add(candidates[i]);
            backTrack(candidates, i, target - candidates[i]);
            track.removeLast();
        }
    }
}
