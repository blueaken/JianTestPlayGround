package ninechapter_algorithm.chapter7_array_and_number.optional.besttimebuyandsellstock2;

/**
 * Author: blueaken
 * Date: 4/27/16 9:35 AM
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
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i-1];
            if (diff > 0) {
                max += diff;
            }
        }
        return max;
    }
}
