package ninechapter_algorithm.chapter7_array_and_number.optional.besttimebuyandsellstock.second;

/**
 * Author: blueaken
 * Date: 5/21/16 12:49
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

        int local = 0;
        int global = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                local = prices[i] - min;
            }
            global = Math.max(local, global);
            min = Math.min(prices[i], min);
        }
        return global;
    }
}
