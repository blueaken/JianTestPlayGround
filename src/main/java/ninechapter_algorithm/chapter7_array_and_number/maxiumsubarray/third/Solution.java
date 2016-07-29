package ninechapter_algorithm.chapter7_array_and_number.maxiumsubarray.third;

/**
 * Author: blueaken
 * Date: 7/27/16 09:48
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

        int local = 0;
        int global = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            local += nums[i];
            local = Math.max(local, nums[i]);
            global = Math.max(local, global);
        }
        return global;
    }
}
