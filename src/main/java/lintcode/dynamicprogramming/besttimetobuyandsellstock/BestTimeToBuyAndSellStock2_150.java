package lintcode.dynamicprogramming.besttimetobuyandsellstock;

public class BestTimeToBuyAndSellStock2_150 {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    //Idea: 直接用贪心比较简单，也试着用DP做一下：DP的规律是第i天的最大利润是第i-1天第最大利润，
    //      加上第i天有无买卖第利润。
    public int maxProfit(int[] prices) {
        // write your code here
        //2. DP solution
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] profits = new int[prices.length];
        profits[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            profits[i] = Math.max(profits[i-1] + (prices[i] - prices[i-1]), profits[i-1]);
        }

        return profits[profits.length-1];

        //1. greedy solution
        // if (prices == null || prices.length == 0) {
        //     return 0;
        // }
        // int profit = 0;
        // for (int i = 1; i < prices.length; i++) {
        //     int diff = prices[i] - prices[i-1];
        //     if (diff > 0) {
        //         profit += diff;
        //     }
        // }
        // return profit;
    }
}
