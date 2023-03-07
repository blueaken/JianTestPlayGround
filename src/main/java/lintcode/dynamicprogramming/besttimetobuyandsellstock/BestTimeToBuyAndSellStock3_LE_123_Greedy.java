package lintcode.dynamicprogramming.besttimetobuyandsellstock;

public class BestTimeToBuyAndSellStock3_LE_123_Greedy {
    /*
        10.13.2022
        ref huifeng guan post
        - since at most 2 transactions, each day only 4 states:
        buy1 = max(buy1, -p);
        sold1 = max(sold1, buy1 + p)
        buy2 = max(buy2, sold1 - p);
        sold2 = max(sold2, buy2 + p);
        - the answer is max(0, sold1, sold2)
        - note the init for buy1 and buy2 should be Integer.MIN_VALUE
        =================
        3.7.2023
        - can use greedy, but try 东哥 template first
        =========
        - try greedy
    */
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE;
        int sold1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int sold2 = 0;

        for (int price : prices) {
            buy1 = Math.max(buy1, -price);
            sold1 = Math.max(sold1, buy1 + price);
            buy2 = Math.max(buy2, sold1 - price);
            sold2 = Math.max(sold2, buy2 + price);
        }
        int res = Math.max(0, sold2);
        return res;
    }
}
