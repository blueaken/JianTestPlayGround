package lintcode.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxNumEventsAttend_LE_1353_Sort_By_StartTime {
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
    */
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> {
            int diff = a[0] - b[0];
            if (diff == 0) {
                return a[1] - b[1];
            } else {
                return diff;
            }
        });

        int count = 0;
        int idx = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int day = 1; day <= 100000; day++) {
            while (idx < events.length && events[idx][0] == day) {
                heap.offer(events[idx][1]);
                idx++;
            }

            //pop the passed due events
            while (!heap.isEmpty() && heap.peek() < day) {
                heap.poll();
            }

            //each day attend only 1 event
            if (!heap.isEmpty()) {
                heap.poll();
                count++;
            }
        }
        return count;
    }
}
