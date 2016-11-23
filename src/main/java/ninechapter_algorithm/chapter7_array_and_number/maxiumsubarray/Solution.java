package ninechapter_algorithm.chapter7_array_and_number.maxiumsubarray;

/**
 * Author: blueaken
 * Date: 4/26/16 11:51 PM
 */
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSum = Integer.MIN_VALUE;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp = Math.max(temp + nums[i], nums[i]);
            maxSum = Math.max(temp, maxSum);
        }
        return maxSum;
    }
}
