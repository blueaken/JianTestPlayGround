package ninechapter_algorithm.chapter7_array_and_number.optional.minimumsubarray;

import java.util.ArrayList;

/**
 * Author: blueaken
 * Date: 5/27/16 11:44
 */
public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return Integer.MAX_VALUE;
        }

        int local = nums.get(0);
        int global = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            local = Math.min(local + nums.get(i), nums.get(i));
            global = Math.min(local, global);
        }
        return global;
    }
}
