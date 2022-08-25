package lintcode.interval;

import java.util.Arrays;
import java.util.PriorityQueue;

public class BrightestPositionOnStreet_LE_2021 {
    /*
        ref - https://leetcode.com/problems/brightest-position-on-street/discuss/1561926/Solution-same-as-meeting-rooms-problem-python
        - similar to meeting room probelm, Time is O(nlogn)
    */
    public int brightestPosition(int[][] lights) {
        int len = lights.length;
        //build the intervals array
        int[][] intervals = new int[len][2];
        for (int i = 0; i < len; i++) {
            int[] light = lights[i];
            intervals[i][0] = light[0] - light[1];
            intervals[i][1] = light[0] + light[1];
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int maxLen = 0, maxIdx = 0;

        for (int i = 0; i < len; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (heap.size() > 0 && heap.peek() < start) {
                heap.poll();
            }
            heap.offer(end);

            if (heap.size() > maxLen) {
                maxLen = heap.size();
                maxIdx = start;
            }
        }
        return maxIdx;
    }

    public static void main(String[] args) {
        BrightestPositionOnStreet_LE_2021 solution = new BrightestPositionOnStreet_LE_2021();
//        int[][] lights = {{-3,2},{1,2},{3,3}}; //-1
//        int[][] lights = {{1,2}}; //-1
        int[][] lights = {{-10,2},{0,3},{5,1}}; //-12

        System.out.println(solution.brightestPosition(lights));
    }
}
