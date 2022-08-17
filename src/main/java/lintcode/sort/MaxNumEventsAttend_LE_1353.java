package lintcode.sort;

import java.util.Arrays;

public class MaxNumEventsAttend_LE_1353 {
    /*
        - kinda similar to 253
        - ref 花花 https://www.youtube.com/watch?v=NjF9JGDGxg8
        - 1. sort by end time (deadline end earlier event handled earlier)
        - 2. choose the 1st available day of each event
        - 3. note the data set is big 10^5, use int array instead of hash set improves performance
        - Brute Force, Time O(N^2), get TLE
    */
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        boolean[] visited = new boolean[100000];
        int count = 0;
        for (int i = 0; i < events.length; i++) {
            //choose the 1st available day from current event
            for (int j = events[i][0]; j <= events[i][1]; j++) {
                if (visited[j]) {
                    continue;
                }
                visited[j] = true;
                count++;
                break;
            }
        }
        return count;
    }
}
