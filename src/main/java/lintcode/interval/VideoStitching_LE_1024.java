package lintcode.interval;

import java.util.Arrays;

public class VideoStitching_LE_1024 {
    /*
        10.26.2022
        ref labuladong post
        - solve by greedy
    */
    public int videoStitching(int[][] clips, int time) {
        if (time == 0) {
            return 0;
        }

        //sort by ascending of start point, if start points are same then order by descending of end point
        Arrays.sort(clips, (a, b) -> {
            if(a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
        });

        int n = clips.length;
        int curEnd = 0, nextEnd = 0;
        int pos = 0;
        int res = 0;
        while (pos < n && clips[pos][0] <= curEnd) {// check "clips[pos][0] <= curEnd" to avoid no overlapping interval
            while (pos < n && clips[pos][0] <= curEnd) {
                nextEnd = Math.max(nextEnd, clips[pos][1]);
                pos++;
            }

            //found next clips, update curEnd
            curEnd = nextEnd;
            res++;

            //check if it can finish the search
            if (curEnd >= time) {
                return res;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        VideoStitching_LE_1024 solution = new VideoStitching_LE_1024();
        int[][] clips = {{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
        int time = 10;
        //Output: 3

        System.out.println(solution.videoStitching(clips, time));
    }
}
