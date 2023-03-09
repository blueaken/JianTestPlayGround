package lintcode.dynamicprogramming2;

import java.util.Arrays;

public class HouseRobber2_LE_213_P1 {
    /*
        10.25.2022
        ref labaladong post
        - 和198不同之处在于首尾房子不能同时选择，那么就比较选择第一个房子和选择最后一个房子之间的最大值即可
        ==================
        3.9.2023
        P1 - refactor LE 198 TopDown DP Method
        ==================
    */
    int[][] mem;
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        mem = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(mem[i], -1);
        }
        return Math.max(dp(nums, 0, n-2), dp(nums, 1, n-1));
    }

    private int dp(int[] nums, int start, int end) {
        // base case;
        if (start > end) {
            return 0;
        }

        if (mem[start][end] != -1) {
            return mem[start][end];
        }

        int res = Math.max(dp(nums, start+1, end), nums[start] + dp(nums, start+2, end));
        mem[start][end] = res;
        return res;
    }
}
