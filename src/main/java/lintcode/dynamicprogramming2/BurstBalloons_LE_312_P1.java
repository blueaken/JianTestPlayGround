package lintcode.dynamicprogramming2;

public class BurstBalloons_LE_312_P1 {
    /*
        - similar to LE 1000 MinCost to merge stones
        ref Huifeng Guan - https://www.youtube.com/watch?v=-HtyovJ4s8Q
        - much elegant than previous solution
        ======================
        P1 10.24.2022
        ref labuladong post
        - solve with bottom up DP, the definition is different than Huifeng Guan's, but similar.
        - still use Huifeng Guan's DP fomulat definition
    */
    public int maxCoins(int[] nums) {
        int n = nums.length;

        //build points array
        int[] points = new int[n+2];
        points[0] = 1;
        points[n+1] = 1;
        for (int i = 1; i <= n; i++) {
            points[i] = nums[i-1];
        }

        //dp[i][j] - 戳破气球 i 和气球 j 之间（闭区间，包括i和j）的所有气球，可以获得的最高分数。（diff from labuladong post）
        int[][] dp = new int[n+2][n+2];
        for (int len = 1; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) { //note: i <= n - len + 1, here n - len + 1 is matching the index of points array
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    int cur = dp[i][k-1] + dp[k+1][j] + points[i-1] * points[k] * points[j+1];
                    dp[i][j] = Math.max(dp[i][j], cur);
                }
            }
        }

        return dp[1][n];
    }
}
