package lintcode.math;

import java.util.Arrays;

public class MaxAreaOfPieceOfCakeHorizontalAndVerticalCuts_LE_1465_P1 {
    /*
        P1
        - ref previous code
        - sort the 2 arrays then find the max gap between each consective elements, the max area is product of the 2 result
        - note - corner case is have to consider the first and the last element's gap as well
    */
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        long maxH = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);//first and last H gap
        for (int i = 1; i < horizontalCuts.length; i++) {
            int diff = horizontalCuts[i] - horizontalCuts[i-1];
            maxH = Math.max(maxH, diff);
        }

        long maxV = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);//first and last V gap
        for (int i = 1; i < verticalCuts.length; i++) {
            int diff = verticalCuts[i] - verticalCuts[i-1];
            maxV = Math.max(maxV, diff);
        }

        long mod = (long)1e9 + 7;
        return (int)((maxH * maxV) % mod);
    }
}
