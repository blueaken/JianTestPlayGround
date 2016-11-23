package ninechapter_algorithm.chapter7_array_and_number.optional.besttimebuyandsellstock.third;

/**
 * Author: blueaken
 * Date: 7/30/16 16:24
 */
public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int lowest = prices[0];
        int global = 0;
        for (int i = 1; i < prices.length; i++) {
            lowest = Math.min(prices[i], lowest);
            global = Math.max(prices[i] - lowest, global);
        }
        return global;
    }
}
