package ninechapter_algorithm.chapter7_array_and_number.optional.maximmproductsubarray;

/**
 * Author: blueaken
 * Date: 5/28/16 09:55
 */
public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int local_max = nums[0];
        int local_min = nums[0];
        int temp_max = 1;
        int temp_min = 1;
        int global = nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp_max = local_max * nums[i];
            temp_min = local_min * nums[i];

            local_max = Math.max(Math.max(temp_max, temp_min), nums[i]);
            local_min = Math.min(Math.min(temp_max, temp_min), nums[i]);
            global = Math.max(local_max, global);
        }
        return global;
    }
}
