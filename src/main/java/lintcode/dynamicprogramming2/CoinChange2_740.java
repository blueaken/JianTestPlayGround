package lintcode.dynamicprogramming2;

public class CoinChange2_740 {
    /**
     * @param amount: a total amount of money amount
     * @param coins: the denomination of each coin
     * @return: the number of combinations that make up the amount
     */
    //Idea: similar to 669, when coins[j] <= i,
    //      res[i][j] = 不选择当前货币的方法 + 选择当前货币方法的总和，即：
    //                  res[i-1][j] + res[i][j-coins[j] + 1]; 否则就等于
    //      不选择当前货币的方法 - res[i-1][j]
    //      Also, ref - https://www.youtube.com/watch?v=_fgjrs570YE
    public int change(int amount, int[] coins) {
        // write your code here
        if (amount == 0) {
            return 0;
        }
        if (coins == null || coins.length == 0) {
            return -1;
        }

        //init
        int size = coins.length;
        int[][] dp = new int[size+1][amount+1];
        for (int i = 0; i <= size; i++) {
            //当amount为0时，有且只有1种方法
            dp[i][0] = 1;
        }

        //dp
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[size][amount];
    }

    public static void main(String[] args) {
        int amount = 8;
        int[] coins = {2, 3, 8};

        CoinChange2_740 solution = new CoinChange2_740();
        System.out.println(solution.change(amount, coins));
    }

}
