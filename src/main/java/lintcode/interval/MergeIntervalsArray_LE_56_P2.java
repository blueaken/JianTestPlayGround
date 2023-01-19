package lintcode.interval;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervalsArray_LE_56_P2 {
    /**
     P2 1.19.2023
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        LinkedList<int[]> res = new LinkedList<>();
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if (res.getLast()[1] < cur[0]) {
                res.add(cur);
            } else {
                res.getLast()[1] = Math.max(res.getLast()[1], cur[1]);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
