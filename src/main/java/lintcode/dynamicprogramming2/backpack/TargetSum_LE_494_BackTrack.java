package lintcode.dynamicprogramming2.backpack;

public class TargetSum_LE_494_BackTrack {
    /*
        10.20.2022
        ref labaladong post
        - solution 1 backtrack - Time - O(2^N), 本质上是二叉树遍历问题，比较低效
        ========================================
        def backtrack(nums, i):
    if i == len(nums):
        if 达到 target:
            result += 1
        return

    for op in { +1, -1 }:
        选择 op * nums[i]
        # 穷举 nums[i + 1] 的选择
        backtrack(nums, i + 1)
        撤销选择
        ===========================================
    */
    int res = 0;
    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, target, 0);
        return res;
    }

    private void backtrack(int[] nums, int remain, int i) {
        if (i == nums.length) {
            if (remain == 0) {
                res++;
            }
            return;
        }

        remain -= nums[i];
        backtrack(nums, remain, i+1);
        remain += nums[i];

        remain += nums[i];
        backtrack(nums, remain, i+1);
        remain -= nums[i];
    }
}
