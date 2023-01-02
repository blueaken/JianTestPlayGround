package lintcode.monotonicqueue;

public class ConstrainedSubsequenceSum_LE_1425_BottomUpDP {
    /**
     1.2.2023
     - similar to 1696, the diff is 1696 must start from nums[0]
     - try with Longest Increasing SubSequence Bottom Up DP - TLE
     */
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        int res = dp[0];
        for (int i = 1; i < n; i++) {
            int maxVal = 0;
            for (int j = 1; j <= k; j++) {
                if (i - j < 0) {
                    continue;
                }
                maxVal = Math.max(maxVal, dp[i - j]);
            }
            dp[i] = maxVal + nums[i];
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
