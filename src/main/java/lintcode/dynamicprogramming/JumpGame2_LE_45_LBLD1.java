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

    // 定义：从索引 pos 跳到最后一格，至少需要 dp(nums, pos) 步
    private int dp(int[] nums, int pos) {
        int n = nums.length;

        //base case
        if (pos >= n-1) {
            return 0;
        }

        if (mem[pos] != n) {
            return mem[pos];
        }

        int maxStep = nums[pos];
        // 你可以选择跳 1 步，2 步...
        for (int i = 1; i <= maxStep; i++) {
            // 穷举每一个选择
            // 计算每一个子问题的结果
            int sub = dp(nums, pos + i);
            // 取其中最小的作为最终结果
            mem[pos] = Math.min(sub + 1, mem[pos]);
        }
        return mem[pos];
    }
}
