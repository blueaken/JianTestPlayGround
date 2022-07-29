package lintcode.dynamicprogramming2;

import java.util.Arrays;

public class MinimumDifficultyJobSchedule_LE_1335 {

    /*
        ref - https://www.youtube.com/watch?v=eRBpfoWujQM, 花花酱讲得不错，虽然他用的是C++;
        - Init - dp[0][0] = 0, others to -1
        - Transition - dp[i][k] = min{dp[j][k-1] + max(jobDiff[j+1 ~ i])}, j >= k - 1, j < i;
        - Answer - dp[n][d]
    */
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;

        if (d > n) {
            //cannot assign at least one job every day
            return -1;
        }

        //init
        int[][] dp = new int[n + 1][d + 1];
        //init to -1
        for (int[] a : dp){
            //init to Max Integer / 2, in case overflow during the calculation
            Arrays.fill(a, Integer.MAX_VALUE / 2);
        }
        dp[0][0] = 0; //init the result of 0 job & 0 day to 0

        //transit
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= d; k++) {
                int maxDiffJob = 0;
                for (int j = i - 1; j >= k - 1; j--) {
                    //find the rolling max difficulty job between j + 1 ~ i
                    maxDiffJob = Math.max(maxDiffJob, jobDifficulty[j]);
                    dp[i][k] = Math.min(dp[i][k], dp[j][k-1] + maxDiffJob);
                }
            }
        }

        return dp[n][d];
    }

    public static void main(String[] args) {
        MinimumDifficultyJobSchedule_LE_1335 solution = new MinimumDifficultyJobSchedule_LE_1335();
//        int[]jobDifficulty = {6,5,4,3,2,1};
//        int days = 2;
//        //7

//        int[]jobDifficulty = {9, 9, 9};
//        int days = 4;
//        //-1

        int[]jobDifficulty = {1,1,1};
        int days = 3;
        //3

        System.out.println(solution.minDifficulty(jobDifficulty, days));
    }
}
