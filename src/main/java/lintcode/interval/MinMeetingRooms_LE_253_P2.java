package lintcode.interval;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinMeetingRooms_LE_253_P2 {
    /*
     - ref the solution link, use priority queue to ease the code.
     - https://leetcode.com/problems/meeting-rooms-ii/solution/
     - Time - O(NLogN + N) ~ O(NLogN), Space - O(N)
     ========================
        P2 11.01.2022
    */
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.offer(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            int curStartTime = intervals[i][0];
            if (curStartTime >= heap.peek()) {
                heap.poll();
            }
            heap.offer(intervals[i][1]);
        }
        return heap.size();
    }
}
