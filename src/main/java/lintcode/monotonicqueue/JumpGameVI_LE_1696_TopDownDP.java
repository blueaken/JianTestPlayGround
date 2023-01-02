package lintcode.monotonicqueue;

import java.util.Arrays;

public class JumpGameVI_LE_1696_TopDownDP {
    /**
     1.2.2023
     - 1st try DP top down with memory optimize - TLE
     */
    int[] memo;

    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, Integer.MIN_VALUE);
        return dp(nums, n-1, k);
    }

    // 定义到达p时最大score为dp(nusm, p, k)
    // 能跳到 nums[p]，必然是从 nums[p-k..p-1] 中的某个位置跳来
    // 故状态转移方程为：dp[p] = max(nums[p-k..p-1]) + nums[p]
    int dp(int[] nums, int p, int k) {
        if (p == 0) {
            return nums[0];
        }
        if (p < 0) {
            return Integer.MIN_VALUE;
        }

        if (memo[p] != Integer.MIN_VALUE) {
            return memo[p];
        }

        for (int i = 1; i <= k; i++) {
            memo[p] = Math.max(memo[p], dp(nums, p-i, k));
        }
        memo[p] += nums[p];
        return memo[p];
    }

}
