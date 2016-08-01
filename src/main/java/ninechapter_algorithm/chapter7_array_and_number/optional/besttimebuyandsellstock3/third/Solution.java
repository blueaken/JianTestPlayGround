package ninechapter_algorithm.chapter7_array_and_number.optional.besttimebuyandsellstock3.third;

/**
 * Author: blueaken
 * Date: 7/31/16 08:43
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
        int profit = 0;
        int[] left = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            lowest = Math.min(prices[i], lowest);
            profit = Math.max(prices[i] - lowest, profit);
            left[i] = profit;
        }

        int highest = prices[prices.length - 1];
        profit = 0;
        int[] right = new int[prices.length];
        //cover the one transaction scenario
        int max = left[prices.length - 1];
        for (int i = prices.length - 1; i > 0; i--) {
            highest = Math.max(prices[i], highest);
            profit = Math.max(highest - prices[i], profit);
            right[i] = profit;

            max = Math.max(right[i] + left[i - 1], max);
        }

        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {1, 2};
        System.out.println(solution.maxProfit(prices));
    }
}
