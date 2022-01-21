package lintcode.twopointers;

import java.util.Arrays;

public class TwoSumClosest_533 {
    /**
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // write your code here
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int left = 0, right = nums.length -1;
        int minDiff = Integer.MAX_VALUE;
        while (left < right) {
            int diff = target - (nums[left] + nums[right]);
            minDiff = Math.min(minDiff, Math.abs(diff));
            if (diff > 0) {
                left++;
            } else if (diff < 0) {
                right--;
            } else {
                break;
            }
        }
        return minDiff;
    }
}
