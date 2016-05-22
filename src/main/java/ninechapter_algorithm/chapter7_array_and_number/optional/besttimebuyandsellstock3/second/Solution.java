package ninechapter_algorithm.chapter7_array_and_number.optional.besttimebuyandsellstock3.second;

/**
 * Author: blueaken
 * Date: 5/21/16 23:07
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

        int[] left = new int[prices.length];
        int local = 0;
        int global = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            local = Math.max(prices[i] - min, local);
            global = Math.max(local, global);
            left[i] = global;
            min = Math.min(prices[i], min);
        }

        int maxProfit = 0;
        int[] right = new int[prices.length];
        local = 0;
        global = 0;
        int max = prices[prices.length - 1];
        for (int i = prices.length - 1; i >= 0; i--) {
            local = Math.max(max - prices[i], local);
            global = Math.max(local, global);
            right[i] = global;
            //need to consider the case of only one trade too - left[i]
            if (i > 0) {
                maxProfit = Math.max(Math.max(left[i - 1] + right[i], left[i]), maxProfit);
            }
            max = Math.max(prices[i], max);
        }
        return maxProfit;
    }
}
