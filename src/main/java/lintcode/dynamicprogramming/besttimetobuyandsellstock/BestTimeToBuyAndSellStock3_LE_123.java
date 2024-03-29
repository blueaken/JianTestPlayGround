package lintcode.dynamicprogramming.besttimetobuyandsellstock;

public class BestTimeToBuyAndSellStock3_LE_123 {
    /*
        10.13.2022
        ref huifeng guan post
        - since at most 2 transactions, each day only 4 states:
        buy1 = max(buy1, -p);
        sold1 = max(sold1, buy1 + p)
        buy2 = max(buy2, sold1 - p);
        sold2 = max(sold2, buy2 + p);
        - the answer is max(0, sold1, sold2)
        - note the init for buy1 and buy2 should be Integer.MIN_VALUE
        =================
        3.7.2023
        - can use greedy, but try 东哥 template first
    */
    public int maxProfit(int[] prices) {
        int K = 2;
        int n = prices.length;
        int[][][] dp = new int[n][K+1][2];
        for (int i = 0; i < n; i++) {
            for (int k = 1; k <= K; k++) {
                if (i - 1 == -1) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = - prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            }
        }
        return dp[n-1][K][0];
    }
}
