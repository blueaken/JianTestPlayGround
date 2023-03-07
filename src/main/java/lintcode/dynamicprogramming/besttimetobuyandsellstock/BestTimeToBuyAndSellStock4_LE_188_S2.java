package lintcode.dynamicprogramming.besttimetobuyandsellstock;

public class BestTimeToBuyAndSellStock4_LE_188_S2 {
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

    */
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[][] sell = new int[n][k+1]; //sell[i][j] - max profit when there is no stock on ith day with j transaction (the last transaction is sell)
        int[][] buy = new int[n][k+1]; //buy[i][j] - max profit when there is stock on ith day with j transaction (the last transaction is buy)

        for (int i = 1; i <= k; i++) {
            //init 0th day buy profit to "-prices[0]"
            buy[0][i] = -prices[0];
        }

        //count every new buy as a transaction (tried count sale as a transaction not work ...)
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                buy[i][j] = Math.max(buy[i-1][j], sell[i-1][j-1] - prices[i]);
                sell[i][j] = Math.max(sell[i-1][j], buy[i-1][j] + prices[i]);
            }
        }

        return sell[n-1][k];//last sold

    }
}
