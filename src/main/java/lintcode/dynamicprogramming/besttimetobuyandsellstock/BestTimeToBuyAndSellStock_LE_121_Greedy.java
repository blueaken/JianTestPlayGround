package lintcode.dynamicprogramming.besttimetobuyandsellstock;

public class BestTimeToBuyAndSellStock_LE_121_Greedy {
    /**
     3.7.2023
     - can use greedy directly, but try 东哥 template this time
     - 相当于K=1 case
     ==========================
     - try greedy
     */
    public int maxProfit(int[] prices) {
        int curMin = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            curMin = Math.min(curMin, prices[i]);
            res = Math.max(res, prices[i] - curMin);
        }
        return res;
    }
}
