package lintcode.dynamicprogramming2.interval1;

import java.util.Arrays;

public class MinimumDifficultyOfJobSchedule_LE_1335_P2 {
    /*
        - P1
        - refer previous notes
        - type: DP
        - dp[i][k] - min job diff within the first i jobs in k days;
        - dp[i][k] - min{dp[j-1][k-1] + max jobdiff[j : i]},   k <= j <= i
        - the trick is make the job array 1 based, to make the definition of job array index and days matching, easy for coding, Overrall time is still O(N^3)
        - dry run example:
        [X X X X X X X X] [j X X i] -  k-1 & 1 个 sub array
               k-1 days   last 1 day
       =================================
       P2 - 10.28.2022
       ref prev notes
       - note need to convert the job array to 1-based
       =================================
    */
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;

        if (d > n) {
            return -1;
        }

        int[] jobs = new int[n+1];
        for (int i = 0; i < n; i++) {
            jobs[i+1] = jobDifficulty[i];
        }

        int[][] dp = new int[n+1][d+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= d; k++) {
                int maxJD = 0;
                for (int j = i; j >= k; j--) {
                    maxJD = Math.max(maxJD, jobs[j]);
                    dp[i][k] = Math.min(dp[i][k], dp[j-1][k-1] + maxJD);
                }
            }
        }
        return dp[n][d];
    }
}
