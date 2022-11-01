package lintcode.math;

import java.util.Arrays;

public class MaxAreaOfPieceOfCakeHorizontalAndVerticalCuts_LE_1465_P2 {
    /*
        P1
        - ref previous code
        - sort the 2 arrays then find the max gap between each consective elements, the max area is product of the 2 result
        - note - corner case is have to consider the first and the last element's gap as well
        ====================
        P2 11.01.2022
        ====================
    */
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        //1st and last horizontal gap
        long maxH = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
        for (int i = 1; i < horizontalCuts.length; i++) {
            maxH = Math.max(maxH, horizontalCuts[i] - horizontalCuts[i-1]);
        }

        //1st and last vertical gap
        long maxW = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);
        for (int i = 1; i < verticalCuts.length; i++) {
            maxW = Math.max(maxW, verticalCuts[i] - verticalCuts[i-1]);
        }

        long mod = (long)1e9 + 7;
        return (int)(maxH * maxW % mod);
    }
}
