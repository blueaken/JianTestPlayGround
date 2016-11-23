package ninechapter_algorithm.chapter7_array_and_number.twosumclosest;

import java.util.Arrays;

/**
 * Author: blueaken
 * Date: 6/2/16 09:36
 */
public class Solution {
    /**
     * @param nums an integer array
     * @param target an integer
     * @return the difference between the sum and the target
     */
    public int twoSumCloset(int[] nums, int target) {
        // Write your code here
        if(nums == null) {
            return -1;
        }

        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int minDiff = Integer.MAX_VALUE;
        while (start < end) {
            int diff = nums[start] + nums[end] - target;
            if (diff == 0) {
                return 0;
            }
            minDiff = Math.min(Math.abs(diff), minDiff);
            if (diff > 0) {
                end--;
            } else {
                start++;
            }
        }
        return minDiff;
    }
}
