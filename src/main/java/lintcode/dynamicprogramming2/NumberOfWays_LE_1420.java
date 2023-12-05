package lintcode.dynamicprogramming2;

public class NumberOfWays_LE_1420 {
    /**
     12.05.23
     - https://leetcode.com/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons/solutions/586576/c-bottom-up-dynamic-programming-with-explanation/
     */
    public int numOfArrays(int n, int m, int k) {
        /**
         - dp[i][j][k]: the number of ways to build array of length i, and the max value in the last slot is j, and search cost is k

         - if arr[i] is the max value on the last slot,
         then dp[i][j][k] = sum(dp[i-1][1..j-1][k-1])

         - if arr[i] is NOT the max value on the last slot, => arr[i] <= j,
         then dp[i][j][k] = dp[i-1][j][k] * j, since the arr[i] value can be any
         number [1..j]

         */
        long[][][] dp = new long[n+1][m+1][k+1];

        long mod = (int)1e9 + 7;

        // base case - when array of length 1, any valid max value, can be found in search cost of 1, since the init value of maxValue is -1, and the array values are positive
        for (int j = 1; j <= m; j++) {
            dp[1][j][1] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int cost = 1; cost <= Math.min(i, k); cost++) {

                    // 1st case - arr[i] is the max value in the last slot
                    for (int t = 1; t < j; t++) {
                        dp[i][j][cost] = (dp[i][j][cost] + dp[i-1][t][cost-1]) % mod;
                    }

                    // 2nd case - arr[i] is NOT the max value in the last slot
                    dp[i][j][cost] = (dp[i][j][cost] + dp[i-1][j][cost] * j % mod) % mod;
                }
            }
        }

        // sum up all valid ways of valid max values with length n and search cost k
        long ans = 0;
        for (int j = 1; j <= m; j++) {
            ans = (ans + dp[n][j][k]) % mod;
        }
        return (int)ans;
    }
}
