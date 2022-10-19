package lintcode.dynamicprogramming2.backpack;

public class CoinChange2_LE_518 {
    /*
        ref labuladong post
        note: 完全背包问题，和0-1背包问题的区别在于完全背包的每个物品可以重复使用
        try Bottom Up with DP table
    */
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1]; //dp[i][j] - 使用前i个硬币（可以重复使用），凑成金额j时的组合方法。

        //base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1; //if amount is 0, then都有1种组合方法，即是什么都不做
        }

        //dp
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i-1]) {
                    //当前coin可以参与
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]; //当前coin不参与 + 当前coin参与的组合方法之和
                } else {
                    //当前coin无法参与
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount];
    }
}
