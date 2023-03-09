package lintcode.dynamicprogramming2;

import java.util.Arrays;

public class HouseRobber_LE_198_P1 {
    /*
        10.25.2022
        ref labaladong post
        - solve with top down DP with mem cache
        ===================
        3.9.2023
        P1
    */
    int[] mem;
    int n;
    public int rob(int[] nums) {
        n = nums.length;
        mem = new int[n];
        Arrays.fill(mem, -1);

        return dp(nums, 0);
    }

    private int dp(int[] nums, int start) {
        // base case
        if (start >= this.n) {
            return 0;
        }

        if (mem[start] != -1) {
            return mem[start];
        }

        int res = Math.max(dp(nums, start+1), nums[start] + dp(nums, start+2)); // 选择不抢/抢的最大值
        mem[start] = res;
        return res;
    }
}
