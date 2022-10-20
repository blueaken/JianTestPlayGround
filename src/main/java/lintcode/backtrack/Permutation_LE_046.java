package lintcode.backtrack;

import java.util.LinkedList;
import java.util.List;

public class Permutation_LE_046 {
    /*
    ref labaladong post
    - type Backtrack
    - 不管怎么优化，都符合回溯框架，而且时间复杂度都不可能低于 O(N!)，因为穷举整棵决策树是无法避免的。
    - 回溯算法的一个特点，不像动态规划存在重叠子问题可以优化，回溯算法就是纯暴力穷举，复杂度一般都很高。
*/
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, path, used);
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> path, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                //nums[i]已在path中
                continue;
            }

            path.add(nums[i]);
            used[i] = true;
            //进入下一层决策
            backtrack(nums, path, used);
            //回溯
            path.removeLast();
            used[i] = false;
        }
        return;
    }
}
