package lintcode.interval;

import java.util.Arrays;
public class VideoStitching_LE_1024_TopDownDP {
    /*
        10.26.2022
        ref labuladong post
        - solve by greedy
        ===============
        7.8.23
        - try Top Down DP inspired by solution post
    */
     Integer[][] mem;
    public int videoStitching(int[][] clips, int time) {
        int n = clips.length;
        mem = new Integer[time+1][n+1];

        // sort by start time
        Arrays.sort(clips, (a, b) -> {
            int diff = Integer.compare(a[0], b[0]);
            if (diff == 0) {
                return Integer.compare(b[1], a[1]);
            }
            return diff;
        });
        return dp(clips, time, n);
    }

    // dp function - return the min number of clips when clips array length is "size" and total during is "time"
    int dp(int[][] clips, int time, int size) {

        // base case 1
        if (time == 0) {
            // when time is 0, answer is always 0
            mem[time][size] = 0;
            return mem[time][size];
        }

        // base case 2
        if (size == 0) {
            // when clip size is 0, there is always no answer, return -1
            mem[time][size] = -1;
            return mem[time][size];
        }

        if (mem[time][size] != null) {
            return mem[time][size];
        }

        int not_take_current = dp(clips, time, size-1);

        int take_current = -1;
        int[] cur = clips[size-1];
        if (cur[0] < time && cur[1] >= time) {
            take_current = dp(clips, cur[0], size-1);
        }

        // analyze results
        int res = -1;
        if (not_take_current == -1 && take_current != -1) {
            res = take_current + 1;
        } else if (not_take_current != -1 && take_current == -1) {
            res = not_take_current;
        } else if (not_take_current != -1 && take_current != -1) {
            res = Math.min(not_take_current, take_current + 1);
        }
        mem[time][size] = res;
        return res;
    }

    public static void main(String[] args) {
        VideoStitching_LE_1024_TopDownDP solution = new VideoStitching_LE_1024_TopDownDP();
        int[][] clips = {{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
        int time = 10;
        //Output: 3

        System.out.println(solution.videoStitching(clips, time));
    }
}
