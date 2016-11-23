package ninechapter_algorithm.chapter7_array_and_number.maximumsubarray2.third;

import java.util.ArrayList;

/**
 * Author: blueaken
 * Date: 7/27/16 14:34
 */
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return 0;
        }

        int[] left = new int[nums.size()];
        int local = 0;
        int global = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            local = Math.max(local + nums.get(i), nums.get(i));
            global = Math.max(local, global);
            left[i] = global;
        }

        local = 0;
        global = Integer.MIN_VALUE;;
        int max = Integer.MIN_VALUE;
        int[] right = new int[nums.size()];
        for (int i = nums.size() - 1; i >= 0; i--) {
            local = Math.max(local + nums.get(i), nums.get(i));
            global = Math.max(local, global);
            right[i] = global;
            if (i > 0) {
                max = Math.max((right[i] + left[i - 1]), max);
            }
        }
        return max;
    }
}
