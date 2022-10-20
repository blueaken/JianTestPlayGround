package lintcode.dynamicprogramming2.backpack;

public class TargetSum_LE_494_BackPackDP {
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

        - solution 2 BackPack DP
        - 这个问题可以转化为一个背包问题中的子集划分问题
        - 如果我们把 nums 划分成两个子集 A 和 B，分别代表分配 + 的数和分配 - 的数，那么他们和 target 存在如下关系：
          Sum(A) - Sum(B) = Target => Sum(A) = (Target + Sum(A) + Sum(B)) / 2
        - 也就是把原问题转化成：nums 中存在几个子集 A，使得 A 中元素的和为 (target + sum(nums)) / 2
    */
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        //invalid conditions check
        if ((sum + target) % 2 == 1 || sum < Math.abs(target)) {
            return 0;
        }

        int amount = (sum + target) / 2;
        int[][] dp = new int[n+1][amount+1];
        dp[0][0] = 1; //如果没有物品，最大容量为0时也是一种装法

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                int cur = nums[i-1];
                if (j < cur) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j - cur];
                }
            }
        }
        return dp[n][amount];
    }
}
