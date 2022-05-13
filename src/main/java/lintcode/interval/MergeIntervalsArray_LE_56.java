package lintcode.interval;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervalsArray_LE_56 {
    /*
        Time - O(NLogN), Space - O(N)
    */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);
        LinkedList<int[]> list = new LinkedList<>();
        list.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > list.getLast()[1]) {
                list.add(intervals[i]);
            } else {
                list.getLast()[1] = Math.max(intervals[i][1], list.getLast()[1]);
            }
        }

        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervalsArray_LE_56 solution = new MergeIntervalsArray_LE_56();
//        int[][] intervals = {{1,3}, {2,6}, {8,10},{15,18}}; //[[1, 6], [8, 10], [15, 18]]
        int[][] intervals = {{1,4}, {0,2}, {3,5}}; //[[0, 5]]
        System.out.println(Arrays.deepToString(solution.merge(intervals)));
    }
}
