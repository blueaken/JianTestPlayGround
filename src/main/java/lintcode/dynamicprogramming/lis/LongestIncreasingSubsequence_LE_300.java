package lintcode.dynamicprogramming.lis;

public class LongestIncreasingSubsequence_LE_300 {
    /*
    10.17.2022
    read labuladong post and redo
    - bottom up DP
    */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1; //base case
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
