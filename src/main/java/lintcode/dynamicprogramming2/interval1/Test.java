package lintcode.dynamicprogramming2.interval1;

import java.util.Arrays;

public class Test {
    /*
        ref - https://www.youtube.com/watch?v=eRBpfoWujQM, 花花酱讲得不错，虽然他用的是Python;
        - Init - dp[0][0] = 0, others to -1
        - Transition - dp[i][k] = min{dp[j][k-1] + max(jobDiff[j+1 ~ i])}, j >= k - 1, j < i;
        - Answer - dp[n][d]
        =====================================================================
        redo ref Huifeng Guan - https://www.youtube.com/watch?v=6T6iK5nFKpg
        - dp - interval 1 type
        - dp[i][k] = dp[j-1][k-1] + max(jobDiff[j ~ i], k <= j <= i
        - [XXXXXXX][jXXXXi] - k-1 & 1个sub array
        - refactor for 0 based index jobDifficulty for time performance and practice
        ====================================================================
    */
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;

        if (d > n) {
            //cannot assign at least one job every day
            return -1;
        }

         int[] jobs = new int[n+1];
         for (int i = 1; i <= n; i++) {
             jobs[i] = jobDifficulty[i-1];
         }

        //init
        int[][] dp = new int[n + 1][d + 1];
        for (int[] a : dp){
            //init to Max Integer / 2, in case overflow during the calculation
            Arrays.fill(a, Integer.MAX_VALUE / 2);
        }
        dp[0][0] = 0; //init the result of 0 job & 0 day to 0

        //transit
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= d; k++) {
                int maxDiffJob = 0;
                for (int j = i; j >= k; j--) {
                    //find the rolling max difficulty job between j ~ i
                    maxDiffJob = Math.max(maxDiffJob, jobs[j]);
                    dp[i][k] = Math.min(dp[i][k], dp[j-1][k-1] + maxDiffJob);
                }
            }
        }

        return dp[n][d];
    }

    // [X X X X X X X] [j X X i]
    //    k - 1 days   last 1 day

    public static void main(String[] args) {
        Test solution = new Test();
        int[] jd = {6,5,4,3,2,1};
        int d = 2;

        System.out.println(solution.minDifficulty(jd, d));
    }
}
