package ninechapter_algorithm.chapter7_array_and_number.optional.besttimebuyandsellstock;

/**
 * Author: blueaken
 * Date: 4/27/16 9:21 AM
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

        int max = 0;
        int temp = 0;
        int lowest = prices[0];
        for (int i = 1; i < prices.length; i++) {
            lowest = Math.min(prices[i], lowest);
            if (prices[i] > lowest) {
                temp = prices[i] - lowest;
            }

            max = Math.max(temp, max);
        }

        return max;
    }
}
