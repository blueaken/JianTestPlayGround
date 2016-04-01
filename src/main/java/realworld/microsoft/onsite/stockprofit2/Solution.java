package realworld.microsoft.onsite.stockprofit2;

/**
 * Author: blueaken
 * Date: 4/1/16 10:47 AM
 */
public class Solution {
    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i-1];
            if (diff > 0) {
                profit += diff;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {10,1,6,7,2,1,5};
        System.out.println(maxProfit(prices));
    }
}
