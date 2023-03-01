package lintcode.backtrack.permutation;

import java.util.LinkedList;
import java.util.List;

public class Permutation_LE_046_P1 {
    /*
        ref labaladong post
        - type Backtrack
        - 不管怎么优化，都符合回溯框架，而且时间复杂度都不可能低于 O(N!)，因为穷举整棵决策树是无法避免的。
        - 回溯算法的一个特点，不像动态规划存在重叠子问题可以优化，回溯算法就是纯暴力穷举，复杂度一般都很高。
        ===================
        3.1.2023
        P1
    */

    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        int n = nums.length;
        boolean[] used = new boolean[n];

        backtrack(nums, track, used);
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            track.add(nums[i]);
            backtrack(nums, track, used);
            track.removeLast();
            used[i] = false;
        }
    }
}
