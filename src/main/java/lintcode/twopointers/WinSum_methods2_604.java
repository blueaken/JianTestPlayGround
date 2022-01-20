package lintcode.twopointers;

import java.util.Arrays;

public class WinSum_methods2_604 {
    /**
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0 || nums.length < k) {
            return null;
        }

        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            res[0] += nums[i];
        }

        for (int i = 1; i < nums.length - k + 1; i++) {
            res[i] = res[i-1] - nums[i-1] + nums[i + k - 1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = {1,2,7,7,2};
        int k = 3;

        WinSum_methods2_604 solution = new WinSum_methods2_604();
        System.out.println(Arrays.toString(solution.winSum(input, k)));
    }
}
