package lintcode.dynamicprogramming;

public class JumpGame2_LE_45_LBLD2 {
    /*
        10.14.2022
        read labuladong post
        - 这个类型题目属于动态规划和贪心之间转换，精句 -
        - 有关动态规划的问题，大多是让你求最值的，比如最长子序列，最小编辑距离，最长公共子串等等等。这就是规律，因为动态规划本身就是运筹学里的一种求最值的算法。
        - 有时间可以从头读一下labuladong的文章
        - 先上一下动态规范解法，可能会TLE
        -------------------
        再试贪心法
        -------------------
    */
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0, farest = 0;
        int jump = 0;
        for (int i = 0; i < n-1; i++) {
            farest = Math.max(farest, nums[i] + i);
            if (end == i) {
                jump++;
                end = farest;
            }
        }
        return jump;
    }
}
