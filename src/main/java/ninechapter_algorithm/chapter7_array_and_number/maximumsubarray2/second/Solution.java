package ninechapter_algorithm.chapter7_array_and_number.maximumsubarray2.second;

import java.util.Arrays;
import java.util.List;

/**
 * Author: blueaken
 * Date: 5/21/16 10:51
 */
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public static int maxTwoSubArrays(List<Integer> nums) {
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

        int[] right = new int[nums.size()];
        local = 0;
        global = Integer.MIN_VALUE;
        int max2SubArrays = Integer.MIN_VALUE;
        for (int i = nums.size() - 1; i >= 0; i--) {
            local = Math.max(local + nums.get(i), nums.get(i));
            global = Math.max(local, global);
            right[i] = global;
            if (i > 0) {
                max2SubArrays = Math.max(right[i] + left[i - 1], max2SubArrays);
            }
        }

        return max2SubArrays;
    }

    public static void main(String[] args) {
        //expect 7
//        List<Integer> test = Arrays.asList(1,3,-1,2,-1,2);

        //expect -2
        List<Integer> test = Arrays.asList(-1,-2,-3,-100,-1,-50);

        System.out.println(maxTwoSubArrays(test));
    }
}
