package ninechapter_algorithm.chapter7_array_and_number.optional.besttimebuyandsellstock4;

/**
 * Author: blueaken
 * Date: 4/27/16 10:37 AM
 */
public class Solution {
    /**
     * @param k: An integer
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public static int maxProfit(int k, int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int days = prices.length;
        int[][] res = new int[k+1][days];

        //init - can omit write it for the clean show of the logic
        for (int i = 0; i <= k; i++) {
            res[i][0] = 0;
        }
        for (int i =0; i < days; i++) {
            res[0][i] = 0;
        }

        //dp
        for (int i = 1; i <= k; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < days; j++) {
                maxDiff = Math.max(res[i-1][j-1] - prices[j-1], maxDiff);
                res[i][j] = Math.max(res[i][j-1], prices[j] + maxDiff);
            }
        }
        return res[k][days-1];
    }

    public static void main(String[] args) {
        int[] prices = {4,4,6,1,1,4,2,5};
        int k = 2;

        System.out.println(maxProfit(k, prices));
    }
}
