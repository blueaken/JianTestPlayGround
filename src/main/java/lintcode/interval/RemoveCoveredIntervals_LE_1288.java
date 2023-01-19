package lintcode.interval;

import java.util.Arrays;

public class RemoveCoveredIntervals_LE_1288 {
    /**
     1.19.2023
     ref 东哥 post, 先按起点排序，再分三种情况讨论处理
     */
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            int diff = a[0] - b[0];
            if (diff == 0) {
                // if same start point then sort by desending order of the end point
                diff = b[1] - a[1];
            }
            return diff;
        });

        int left = intervals[0][0];
        int right = intervals[0][1];

        int covered = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (left <= interval[0] && right >= interval[1]) {
                covered++;
            }
            if (right >= interval[0] && right <= interval[1]) {
                // merged into a bigger interval
                right = interval[1];
            }
            if (right < interval[0]) {
                left = interval[0];
                right = interval[1];
            }
        }
        return intervals.length - covered;
    }
}
