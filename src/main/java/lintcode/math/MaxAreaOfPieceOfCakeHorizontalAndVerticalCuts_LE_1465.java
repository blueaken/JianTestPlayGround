package lintcode.math;

import java.util.Arrays;

public class MaxAreaOfPieceOfCakeHorizontalAndVerticalCuts_LE_1465 {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        long mod = (long)1e9 + 7;
        long maxH, maxV;
        maxH = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);//first and last horizontal space
        for (int i = 1; i < horizontalCuts.length; i++) {
            int cur = horizontalCuts[i] - horizontalCuts[i-1];
            maxH = Math.max(maxH, cur);
        }

        maxV = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);//first and last vertical space
        for (int i = 1; i < verticalCuts.length; i++) {
            int cur = verticalCuts[i] - verticalCuts[i-1];
            maxV = Math.max(maxV, cur);
        }

        return (int) ((maxH * maxV) % mod);
    }

    public static void main(String[] args) {
        MaxAreaOfPieceOfCakeHorizontalAndVerticalCuts_LE_1465 solution = new MaxAreaOfPieceOfCakeHorizontalAndVerticalCuts_LE_1465();
        int h = 5, w = 4;
        int[] horizontalCuts = {1,2,3};
        int[] verticalCuts = {1,3};
        //4

//        int h = 5, w = 4;
//        int[] horizontalCuts = {3,1};
//        int[] verticalCuts = {1};
//        //6

        System.out.println(solution.maxArea(h, w, horizontalCuts, verticalCuts));
    }
}
