package ninechapter_algorithm.chapter7_array_and_number.maximumsubarray2;

import java.util.ArrayList;

/**
 * Author: blueaken
 * Date: 4/27/16 12:18 AM
 */
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public static int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return 0;
        }

        int left[] = new int[nums.size()];
        int local = 0;
        int global = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            local = Math.max(local + nums.get(i), nums.get(i));
            global = Math.max(local, global);
            left[i] = global;
        }

        local = 0;
        global = Integer.MIN_VALUE;
        int right[] = new int[nums.size()];
        int result = Integer.MIN_VALUE;
        for (int i =  nums.size() - 1; i >= 0; i--) {
            local = Math.max(local + nums.get(i), nums.get(i));
            global = Math.max(local, global);
            right[i] = global;
            if (i-1 >= 0) {
                result = Math.max(left[i-1] + right[i], result);
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = {1,3,-1,2,-1,2};
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(3);
        nums.add(-1);
        nums.add(2);
        nums.add(-1);
        nums.add(2);

        System.out.println(maxTwoSubArrays(nums));
    }
}
