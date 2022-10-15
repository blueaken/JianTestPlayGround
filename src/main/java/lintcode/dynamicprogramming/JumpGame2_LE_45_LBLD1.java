package lintcode.dynamicprogramming;

import java.util.Arrays;

public class JumpGame2_LE_45_LBLD1 {
    /*
        read labuladong post
        - 这个类型题目属于动态规划和贪心之间转换，精句 -
        - 有关动态规划的问题，大多是让你求最值的，比如最长子序列，最小编辑距离，最长公共子串等等等。这就是规律，因为动态规划本身就是运筹学里的一种求最值的算法。
        - 有时间可以从头读一下labuladong的文章
        - 先上一下动态规范解法，可能会TLE
    */
    int[] mem;
    public int jump(int[] nums) {
        int n = nums.length;
        mem = new int[n];
        Arrays.fill(mem, n);

        return dp(nums, 0);
    }

    private int dp(int[] nums, int curStep) {
        int n = nums.length;

        //base case
        if (curStep >= n-1) {
            return 0;
        }

        if (mem[curStep] != n) {
            return mem[curStep];
        }

        int maxStep = nums[curStep];
        for (int i = 1; i <= maxStep; i++) {
            int sub = dp(nums, curStep + i);
            mem[curStep] = Math.min(sub + 1, mem[curStep]);
        }
        return mem[curStep];
    }
}
