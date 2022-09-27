package lintcode.greedy;

import java.util.Arrays;

public class EraseOverlapIntervals_LE_435 {
    /*
        - similar to 1235
        - Type： interval DP ordered by endtime
        - it asked min intervals to remove, use DP to find the max non-overlapping intervals possible, then use intervals size - dp result
        - 1. sort by endtime
        - 2. a. if intervals[i] is overlapping to intervals[i-1], then dp[i] = max(dp[i-1], dp[j] + 1), 0 <= j < i, and intervals[j] is the 1st no-overlapping to intervals[i]
             b. if inervals[i] is not overlapping to intervals[i-1], then dp[i] = dp[i-1] + 1;
          Time - O(N^2)
        ========================================
        - DP solution got TLE, refactor with greedy ref solution link
        Time - O(NLogN)
    */
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int n = intervals.length;

        int end = intervals[0][1], maxIntervals = 1;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                maxIntervals++;
            }
        }
        return n - maxIntervals;
    }
}
