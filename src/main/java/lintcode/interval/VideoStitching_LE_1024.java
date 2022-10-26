package lintcode.interval;

import java.util.Arrays;

public class VideoStitching_LE_1024 {
    /*
        10.26.2022
        ref labaladong post
        - solve by greedy
    */
    public int videoStitching(int[][] clips, int time) {
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

            //check if can finish the search
            if (curEnd >= time) {
                return res;
            }

        }
        return -1;
    }
}
