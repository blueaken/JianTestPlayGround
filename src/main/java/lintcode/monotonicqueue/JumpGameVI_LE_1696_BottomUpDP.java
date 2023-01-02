package lintcode.monotonicqueue;

import java.util.Arrays;

public class JumpGameVI_LE_1696_BottomUpDP {
    /**
     1.2.2023
     - 1st try DP top down with memory optimize - TLE
     - 2nd try bottom up DP (preparing for optimizatioin with Monotonic Queue) - TLE
     */

    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];

        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];
        for (int p = 1; p < n; p++) {
            for (int i = 1; i <= k; i++) {
                if (p - i < 0) {
                    continue;
                }
                dp[p] = Math.max(dp[p], dp[p-i]);
            }
            dp[p] += nums[p];
        }

        return dp[n-1];
    }
}
