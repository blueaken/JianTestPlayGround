package lintcode.twopointers;

import java.util.Arrays;

public class WinSum_604 {
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
        for (int i = 0; i < nums.length - k + 1; i++) {
            int sum = 0;
            for (int j = i; j < k + i; j++) {
                sum += nums[j];
            }
            res[i] = sum;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = {1,2,7,7,2};
        int k = 3;

        WinSum_604 solution = new WinSum_604();
        System.out.println(Arrays.toString(solution.winSum(input, k)));
    }
}
