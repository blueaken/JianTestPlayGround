package lintcode.dynamicprogramming.besttimetobuyandsellstock;

public class BestTimeToBuyAndSellStock_LE_121 {
    /**
     3.7.2023
     - can use greedy directly, but try 东哥 template this time
     - 相当于K=1 case
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = - prices[i];
                continue;
            }

            // dp[i-1][0] = 0, since k = 0 at this time
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], - prices[i]);
        }
        return dp[n-1][0];
    }
}
