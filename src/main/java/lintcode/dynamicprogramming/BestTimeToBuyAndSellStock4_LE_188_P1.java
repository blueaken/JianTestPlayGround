package lintcode.dynamicprogramming;

public class BestTimeToBuyAndSellStock4_LE_188_P1 {
    /*
        10.13.2022
        - ref privous notes and get a basic DP formula
        - dp[i][j] - max profit with i transactioins in jth day
        - for each day, if no transaction - max_profit_no_trans = dp[i][j-1];
                         if has transaction, max_profit_with_trans = max{prices[j] - prices[m] + dp[i-1][m]},
                                                                                                    0 <=m < j
          dp[i][j] = max{max_profit_no_trans, max_profit_with_trans}
          Time - O(N^3)
          =========================
          Solutioin 2 -
          ref huifeng guan video - https://www.youtube.com/watch?v=lXRe__YD8JY
          Time - O(N^2)
          =========================
          P1 10.31.2022
          ref labuladong briliant post
          note: time is slower than 2 seperate sell & buy array
          ==========================
    */
    public int maxProfit(int K, int[] prices) {
        int n = prices.length;

        if (K > n/2) {
            return maxProfitInf(prices);
        }

        int[][][] dp = new int[n][K+1][2];

        for (int i = 0; i < n; i++) {
            for (int k = 1; k <= K; k++) {
                if (i-1 == -1) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }

                //note every buy count the start of a transaction
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            }
        }
        return dp[n-1][K][0];
    }

    //solve the infinite transaction with greedy
    private int maxProfitInf(int[] prices) {
        int n = prices.length;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            int cur = prices[i] - prices[i-1];
            if (cur > 0) {
                ans += cur;
            }
        }
        return ans;
    }
}
