package lintcode.dynamicprogramming2;

public class MinCostToMergeStones_LE_1000 {
    /*
        ref Guifeng Guan video - https://www.youtube.com/watch?v=S1IUYAtgzus
        - can be further optimized, but beat 50% should be good enough for interview
        - dp[i][j][k] = min(dp[i][m][1] + dp[m+1][j][k-1]), i <= m < j
        - dp[i][j][1] = dp[i][j][k] + sum[i ~ j]
    */
    public int mergeStones(int[] stones, int K) {
        int n = stones.length;
        if ((n-1) % (K-1) != 0) {
            return -1;
        }

        //calc pre sum, 1 index, sum[i~j] = sum[j+1] - sum[i]
        int[] sum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i-1] + stones[i-1];
        }

        //init
        int[][][] dp = new int[n][n][K+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 1; k <= K; k++) {
                    if (i == j && k == 1) {
                        //dp[i][i][1] cost should be 0
                        continue;
                    }
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                for (int k = 2; k <= K; k++) {
                    for (int m = i; m < j; m++) {
                        if (dp[i][m][1] == Integer.MAX_VALUE || dp[m+1][j][k-1] == Integer.MAX_VALUE) {
                            continue;
                        }
                        dp[i][j][k] = Math.min(dp[i][j][k], dp[i][m][1] + dp[m+1][j][k-1]);
                    }
                }
                if (dp[i][j][K] != Integer.MAX_VALUE) {
                    dp[i][j][1] = dp[i][j][K] + sum[j+1] - sum[i];
                }
            }
        }
        return dp[0][n-1][1] == Integer.MAX_VALUE ? -1 : dp[0][n-1][1];
    }
}
