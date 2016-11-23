package ninechapter_algorithm.chapter7_array_and_number.optional.maximumsubarray3.second;

import java.util.Arrays;

/**
 * Author: blueaken
 * Date: 5/23/16 23:58
 */
public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0 || k > nums.length) {
            return 0;
        }

        int[][] local = new int[nums.length + 1][k + 1];
        int[][] global = new int[nums.length + 1][k + 1];

        //count positive integer
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                count++;
            }
        }
        if (k <= count) {
            //dp
            for (int i = 1; i <= nums.length; i++) {
                for (int j = 1; j <= k; j++) {
                    local[i][j] = Math.max(local[i - 1][j], global[i - 1][j - 1]) + nums[i - 1];
                    global[i][j] = Math.max(local[i][j], global[i - 1][j]);
                }
            }
            return global[nums.length][k];
        } else {
            //when k > positive numbers then it equals the sum of k biggest numbers
            Arrays.sort(nums);
            int sum = 0;
            int stop = nums.length - k;
            for (int i = nums.length - 1; i >= stop; i--) {
                sum += nums[i];
            }
            return sum;
        }
    }
}
