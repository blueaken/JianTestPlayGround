package lintcode.interval;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxNumEventsAttend_LE_1353_Sort_By_StartTime_P1 {
    /*
        - kinda similar to 253
        - ref 花花 https://www.youtube.com/watch?v=NjF9JGDGxg8
        - 1. sort by end time (deadline end earlier event handled earlier)
        - 2. choose the 1st available day of each event
        - 3. note the data set is big 10^5, use int array instead of hash set improves performance
        - Brute Force, Time O(N^2), get TLE
        ========================================================================
        - Ref Huifeng Guan https://www.youtube.com/watch?v=9bJvSySPcZM
        - 1. sort by start time, if start time ties then sort by end time
        - 2. loop over the days 1 to 10000, attend as much as you can
        - use heap to help sort the end time
        - Time O(NLogN)
        ==========================================
        P1 11.02.2022
        - actually can sort by start time only with the minHeap
        ==========================================
    */
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int idx = 0, count = 0;
        for (int curDay = 1; curDay <= 100000; curDay++) {
            //add the end days of all events start day is current day into the heap
            while (idx < events.length && events[idx][0] == curDay) {
                heap.offer(events[idx][1]);
                idx++;
            }

            //remove the passed due events
            while (heap.size() > 0 && heap.peek() < curDay) {
                heap.poll();
            }

            //attend today's event and count
            if (heap.size() > 0) {
                heap.poll();
                count++;
            }
        }
        return count;

    }
}
