package lintcode.interval;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinMeetingRooms_LE_253 {
    /*
     - ref the solution link, use priority queue to ease the code.
     - https://leetcode.com/problems/meeting-rooms-ii/solution/
     - Time - O(NLogN + N) ~ O(NLogN), Space - O(N)
    */
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int count = 1;
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        endTimes.offer(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            int curStartTime = intervals[i][0];
            if (curStartTime >= endTimes.peek()) {
                //reuse exisiting
                endTimes.poll();
            } else {
                //allocate new room
                count++;
            }
            endTimes.offer(intervals[i][1]);
        }

        return count;
    }
}
