package lintcode.dynamicprogramming.lis;

public class PaintHouse_LE_256 {
    /*
        10.17.2022
        - read labuladuo post
        - tag: DP, LIS
        - Bottom Up DP - dp[i][j] = MinCost of painting house 0..i and last color is j
    */
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n][3];

        //init
        for (int i = 0; i < 3; i++) {
            dp[0][i] = costs[0][i];
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + costs[i][2];
        }

        //return min cost of the last house
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            ans = Math.min(ans, dp[n-1][i]);
        }
        return ans;
    }
}
