package lintcode.dynamicprogramming;

public class FibonacciNumber_LE_509 {
    /**
     2.28.2023
     - bottom up with DP table, 东哥 template
     ==========================
     - try space optimization
     */
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        // int[] dp = new int[n+1];
        // base case
        // dp[0] = 0;
        // dp[1] = 1;

        int dp_i_1 = 1, dp_i_2 = 0;
        for (int i = 2; i <= n; i++) {
            // dp[i] = dp[i-1] + dp[i-2];
            int dp_i = dp_i_1 + dp_i_2;
            // note, 滚动更新, 注意顺序
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i_1;
    }
}
