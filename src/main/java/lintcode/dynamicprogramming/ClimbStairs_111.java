package lintcode.dynamicprogramming;

public class ClimbStairs_111 {
    /**
     * @param n: An integer
     * @return: An integer
     */
    //Idea: 简单的DP，到达第n阶的方案数为到第n-1阶和n-2阶方案数的总和;
    //      Ref一下https://www.lintcode.com/problem/111/solution
    public int climbStairs(int n) {
        // write your code here
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
