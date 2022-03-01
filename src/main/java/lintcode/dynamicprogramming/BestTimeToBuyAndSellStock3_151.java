package lintcode.dynamicprogramming;

public class BestTimeToBuyAndSellStock3_151 {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    //Idea: 状态机DP，参考 https://www.lintcode.com/problem/151/solution/16609,
    //      任然有些不明白，先写在这里。和背包问题相似，也许可以从那里入手
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int K = 2;
        // corner case
        if (n == 0 || K == 0){
            return 0;
        }
        // main part
        int[][] dp = new int[K + 1][n];
        for (int i = 1; i < dp.length; i ++){
            int maxDiff = -prices[0];
            for (int j = 1; j < dp[0].length; j ++){
                maxDiff = Math.max(maxDiff, dp[i - 1][j - 1] - prices[j]);
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxDiff);
            }
        }
        return dp[K][n - 1];
    }

    public static void main(String[] args) {
        int[] prices = {6,1,1,4,2,5};

        BestTimeToBuyAndSellStock3_151 solution = new BestTimeToBuyAndSellStock3_151();
        System.out.println(solution.maxProfit(prices));
    }
}
