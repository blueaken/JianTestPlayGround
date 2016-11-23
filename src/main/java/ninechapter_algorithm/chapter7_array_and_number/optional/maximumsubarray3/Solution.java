package ninechapter_algorithm.chapter7_array_and_number.optional.maximumsubarray3;

/**
 * Author: blueaken
 * Date: 4/27/16 11:12 AM
 */
public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(int[] nums, int k) {
        // write your code here
        //similar to 1st solution of buy and sell stock 4
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[][] res = new int[k+1][len];

        //init - can omit but just to show the logic
        for (int i = 0; i <= k; i++) {
            res[i][0] = 0;
        }
        for (int i = 0; i < len; i++) {
            res[0][i] = 0;
        }

        //dp
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < len; j++) {
                int global = 0;
                for (int m = 0; m <= j; m++) {
                    int temp = 0;
                    temp = Math.max(temp + nums[m], nums[m]);
                    global = Math.max(temp + res[i-1][m], global);
                }
                res[i][j] = Math.max(res[i][j-1], global);
            }
        }

        return res[k][len-1];
    }
}
