package lintcode.dynamicprogramming.besttimetobuyandsellstock;

public class BestTimeToBuyAndSellStock2_LE_122 {
    /**
     3.7.2023
     can use greedy, but try 东哥 template first
     - 相当于K = infinite情况，也就是 k = k - 1
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[n-1][0];
    }
}
