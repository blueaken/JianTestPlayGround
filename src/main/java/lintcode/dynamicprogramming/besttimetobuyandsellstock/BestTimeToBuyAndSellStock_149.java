package lintcode.dynamicprogramming.besttimetobuyandsellstock;

public class BestTimeToBuyAndSellStock_149 {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    //Idea: 不断最低价格，比较利润，比较直观；另外，也可以用DP来解。
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int lowestPrice = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            lowestPrice = Math.min(prices[i], lowestPrice);
            ans = Math.max(prices[i] - lowestPrice, ans);
        }

        return ans;
    }
}
