package lintcode.dynamicprogramming.besttimetobuyandsellstock;

public class BestTimeToBuyAndSellStock2_LE_122_Greedy {
    /**
     3.7.2023
     can use greedy, but try 东哥 template first
     - 相当于K = infinite情况，也就是 k = k - 1
     =======================
     try greedy
     */
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            int curProfit = prices[i] - prices[i-1];
            if (curProfit > 0) {
                res += curProfit;
            }
        }
        return res;
    }
}
