package lintcode.dynamicprogramming.besttimetobuyandsellstock;

public class BestTimeToBuyAndSellStock4_LE_188_S1 {
    /*
        10.13.2022
        - ref privous notes and get a basic DP formula
        - dp[i][j] - max profit with i transactioins in jth day
        - for each day, if no transaction - max_profit_no_trans = dp[i][j-1];
                         if has transaction, max_profit_with_trans = max{prices[j] - prices[m] + dp[i-1][m]},
                                                                                                    0 <=m < j
          dp[i][j] = max{max_profit_no_trans, max_profit_with_trans}

    */
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[][] dp = new int[k+1][n];
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < n; j++) {
                int max_profit_no_trans = dp[i][j-1];
                int max_profit_with_trans = 0;
                for (int m = 0; m < j; m++) {
                    int curProfit = prices[j] - prices[m] + dp[i-1][m];
                    max_profit_with_trans = Math.max(max_profit_with_trans, curProfit);
                }
                dp[i][j] = Math.max(max_profit_no_trans, max_profit_with_trans);
            }
        }
        return dp[k][n-1];
    }
}
