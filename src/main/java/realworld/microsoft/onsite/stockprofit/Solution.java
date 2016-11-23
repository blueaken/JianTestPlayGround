package realworld.microsoft.onsite.stockprofit;

/**
 * Author: blueaken
 * Date: 4/1/16 10:30 AM
 */
public class Solution {
    public static int maxProfit(int[] prices) {
        int low = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            low = Math.min(prices[i], low);
            profit = Math.max(prices[i] - low, profit);
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {10,1,6,7,2,1,5};
        System.out.println(maxProfit(prices));
    }
}
