package lintcode.dynamicprogramming2;

import java.util.Arrays;

public class WeightedJobSchedulingMaximumProfit_LE_1235_P1 {
    /*
        P1
        - Type DP
        - ref preview notes, looks no need for Binary Search, can use DP directly
        - 1. sort by endTime
        - 2. dp[i] = max(profit[i], dp[i-1], profit[i] + dp[j]), 0 <= j < i & job[j] not overlapping with job[i], i denotes job endtime
    */
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        //sort by endTime
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        int[] dp = new int[n];
        dp[0] = jobs[0][2];

        int ans = 0;
        for (int end = 1; end < n; end++) {
            dp[end] = Math.max(jobs[end][2], dp[end-1]);
            for (int start = end - 1; start >= 0; start--) {
                if (isNotOverlapping(jobs[start], jobs[end])) {
                    dp[end] = Math.max(dp[end], jobs[end][2] + dp[start]);
                    break;//can break since current dp[start] has coverd jobs before it
                }
            }
            ans = Math.max(ans, dp[end]);
        }
        return ans;
    }

    private boolean isNotOverlapping(int[] start, int[] end) {
        return start[1] <= end[0];
    }
}
