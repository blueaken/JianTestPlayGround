package lintcode.dynamicprogramming.besttimetobuyandsellstock;

public class BestTimeToBuyAndSellStock4_LE_188_P2 {
    /*
        10.13.2022
        - ref previous notes and get a basic DP formula
        - dp[i][j] - max profit with i transactioins in jth day
        - for each day, if no transaction - max_profit_no_trans = dp[i][j-1];
                         if has transaction, max_profit_with_trans = max{prices[j] - prices[m] + dp[i-1][m]},
                                                                                                    0 <=m < j
          dp[i][j] = max{max_profit_no_trans, max_profit_with_trans}
          Time - O(N^3)
          =========================
          Solution 2 -
          ref huifeng guan video - https://www.youtube.com/watch?v=lXRe__YD8JY
          Time - O(N^2)
          =========================
          P1 10.31.2022
          ref 东哥 brilliant post
          note: time is slower than 2 separate sell & buy array
          ==========================
          3.7.2023
          P2 with 东哥 post
    */
    public int maxProfit(int K, int[] prices) {
        int n = prices.length;
        if (K > n / 2) {
            return maxProfitWithIK(prices);
        }

        int[][][] dp = new int[n][K+1][2];
        for (int i = 0; i < n; i++) {
            for (int k = 1; k <= K; k++) {
                if (i - 1 == -1) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            }
        }
        return dp[n-1][K][0];
    }

    // solve infinite transaction with greedy
    private int maxProfitWithIK(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            int curProfit = prices[i] - prices[i-1];
            if (curProfit > 0) {
                res += curProfit;
            }
        }
        return res;
    }
}
