package lintcode.interval;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervalsArray_LE_56_P1 {
    /*
        Time - O(NLogN), Space - O(N)
    */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        LinkedList<int[]> res = new LinkedList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > res.getLast()[1]) {
                res.add(intervals[i]);
            } else {
                res.getLast()[1] = Math.max(res.getLast()[1], intervals[i][1]);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {
        MergeIntervalsArray_LE_56_P1 solution = new MergeIntervalsArray_LE_56_P1();
//        int[][] intervals = {{1,3}, {2,6}, {8,10},{15,18}}; //[[1, 6], [8, 10], [15, 18]]
//        int[][] intervals = {{1,4}, {0,2}, {3,5}}; //[[0, 5]]
//        int[][] intervals = {{2,3},{4,5},{6,7},{8,9},{1,10}}; // [[1,10]]
        int[][] intervals = {{0,8},{1,5},{4,7},{9,14},{10,15},{11,11},{13,13},{16,19},{17,22},{18,23},{20,20},{21,21}}; // [[0, 8], [9, 15], [16, 23]]
        System.out.println(Arrays.deepToString(solution.merge(intervals)));
    }
}
