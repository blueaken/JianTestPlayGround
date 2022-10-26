package lintcode.greedy;

import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons_LE_452 {
    /*
        10.26.2022
        ref labaladong post
        - similar to 435 - the min ArrowShots is the max number of non-overlapping intervals
        - note a slight diff is the boundary if xstart <= x <= xend, the baloon also burst
    */
    public int findMinArrowShots(int[][] points) {
        //note we can't simply use the a[1] - b[1] trick, as this will cause an integer overflow for very large or small values.
        Arrays.sort(points, (a, b) -> {
            if (a[1] == b[1]) {
                return 0;
            } else if (a[1] < b[1]) {
                return -1;
            } else {
                return 1;
            }

        });
        int n = points.length;

        int x_end = points[0][1];
        int count = 1;
        for (int i = 1; i < n; i++) {
            int[] cur = points[i];
            if (cur[0] > x_end) {
                count++;
                x_end = cur[1];
            }
        }
        return count;
    }
}
