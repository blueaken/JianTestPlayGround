package lintcode.interval;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinMeetingRooms_LE_253_P1 {
    /*
     - ref the solution link, use priority queue to ease the code.
     - https://leetcode.com/problems/meeting-rooms-ii/solution/
     - Time - O(NLogN + N) ~ O(NLogN), Space - O(N)
     - Following up on the problem hints, we can make use of a min-heap to store the end times of the meetings in various rooms. So, every time we want to check if any room is free or not, simply check the topmost element of the min heap as that would be the room that would get free the earliest out of all the other rooms currently occupied. If the room we extracted from the top of the min heap isn't free, then no other room is. So, we can save time here and simply allocate a new room.
    */
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.offer(intervals[0][1]);
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            int curStartTime = intervals[i][0];

            if (curStartTime >= heap.peek()) {
                //if current meeting room satisfy then update the heap with the new meeting endtime
                heap.poll();
            } else {
                //current meeting room cannot satisfy then allocate a new room
                count++;
            }
            heap.offer(intervals[i][1]);
        }
        return count;
    }

    public static void main(String[] args) {
        MinMeetingRooms_LE_253_P1 solution = new MinMeetingRooms_LE_253_P1();
        int[][] intervals = {{2,3},{4,5},{6,7},{8,9},{1,10}}; //2
        System.out.println(solution.minMeetingRooms(intervals));
    }
}
