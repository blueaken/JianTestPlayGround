package lintcode.greedy;

import java.util.Arrays;

public class EraseOverlapIntervals_LE_435_P1 {
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
        ===============================================
        10.26.2022
        P1 - ref labaladong post - solve with greedy
        also ref Huifeng Guan's comments on this one
        - 我们之前总结过，对区间排序的贪心法，有的需要sort by starting point，有的需要sort by ending point. 大致的规律是：

        如果求的是maximum number of non-overlapping intervals，用sort by ending point的方法
        如果求的是minimum number of intervals to cover the whole range，用sort by starting point的方法

        本题就是前者。
        ===============================
    */
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int n = intervals.length;

        int x_end = intervals[0][1];
        int count = 1;
        for (int i = 1; i < n; i++) {
            int[] cur = intervals[i];
            if (cur[0] >= x_end) {
                count++;
                x_end = cur[1];
            }
        }
        return n - count;
    }
}
