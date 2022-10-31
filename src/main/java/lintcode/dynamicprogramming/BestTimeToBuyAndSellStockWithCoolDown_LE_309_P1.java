package lintcode.dynamicprogramming;

public class BestTimeToBuyAndSellStockWithCoolDown_LE_309_P1 {
    /*
        10.14.2022
        read through labuladong 团灭帖子, 佩服！有些细节处理在Huifeng Guan的post中也许回避了，他也正面回应了，赞！

        - 以前我以为在 sell 的时候给 k 减小 1 和在 buy 的时候给 k 减小 1 是等效的，但细心的读者向我提出质疑，经过深入思考我发现前者确实是错误的，因为交易是从 buy 开始，如果 buy 的选择不改变交易次数 k 的话，会出现交易次数超出限制的的错误。

        base case：
        dp[-1][...][0] = dp[...][0][0] = 0
        dp[-1][...][1] = dp[...][0][1] = -infinity

        状态转移方程：
        dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
        dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])

        关于本题，由于k为无穷大可以从方程中去掉，另外由于有1天冷冻期，在第i天选择buy的时候，状态转移从i-2开始，不是i-1:
        dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
        dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
        =========================
        P1 10.31.2022
        =========================
    */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            if (i-1 < 0) {
                dp[i][0] = 0;
                dp[i][1] = - prices[i];
                continue;
            }
            if (i-2 < 0) {
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] -prices[i]);
        }
        return dp[n-1][0];
    }
}
