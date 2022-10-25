package lintcode.dynamicprogramming2;

import java.util.Arrays;

public class HouseRobber_LE_198 {
    /*
        10.25.2022
        ref labaladong post
        - solve with top down DP with mem cache
    */
    int[] mem;
    public int rob(int[] nums) {
        mem = new int[nums.length];
        Arrays.fill(mem, -1);

        return dp(nums, 0); //arr, start index
    }

    private int dp(int[] nums, int start) {
        //base case
        if (start >= nums.length) {
            return 0;
        }

        if (mem[start] != -1) {
            return mem[start];
        }

        //dp
        //max of no rob case and rob case
        mem[start] = Math.max(dp(nums, start + 1), nums[start] + dp(nums, start + 2));
        return mem[start];
    }
}
