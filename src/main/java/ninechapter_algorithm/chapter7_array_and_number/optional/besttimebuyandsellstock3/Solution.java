package ninechapter_algorithm.chapter7_array_and_number.optional.besttimebuyandsellstock3;

/**
 * Author: blueaken
 * Date: 4/27/16 9:54 AM
 */
public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public static int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int low = Integer.MAX_VALUE;
        int max = 0;
        int[] first = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            low = Math.min(low, prices[i]);
            max = Math.max(prices[i] - low, max);
            first[i] = max;
        }

        int high = Integer.MIN_VALUE;
        int result = 0;
        max = 0;
        int[] second = new int[prices.length];
        for (int i = prices.length - 1; i >= 0; i--) {
            high = Math.max(high, prices[i]);
            max = Math.max(high - prices[i], max);
            second[i] = max;
            if (i - 1 >= 0) {
                result = Math.max(Math.max(first[i-1] + second[i], first[i]), result);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] prices = {4,4,6,1,1,4,2,5};
        System.out.println(maxProfit(prices));
    }
}
