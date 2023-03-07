package lintcode.dynamicprogramming.besttimetobuyandsellstock;

public class BestTimeToBuyAndSellStockWithFee_LE_714 {
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

        关于本题，由于k为无穷大可以从方程中去掉，将交易费放在buy的时候扣除得到:

        dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
        dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i] - fee)

        Note - 把 fee 放在dp[i][0]里减，会有一些测试用例无法通过，错误原因是整型溢出而不是思路问题。一种解决方案是把代码中的 int 类型都改成 long 类型，避免 int 的整型溢出。放在dp[i][1]中减没有碰到这个问题。
    */
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            if (i-1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[0] - fee;
                continue;
            }

            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i] - fee);
        }
        return dp[n-1][0];
    }
}
