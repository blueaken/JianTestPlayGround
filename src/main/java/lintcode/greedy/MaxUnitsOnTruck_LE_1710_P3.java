package lintcode.greedy;

import java.util.Arrays;

public class MaxUnitsOnTruck_LE_1710_P3 {
    /*
        P2
        - heap with greedy
        ==================
        P3 11.01.2022
        - refactor previous solution with array loop directly
        ==================
    */
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int ans = 0;
        for (int[] boxType : boxTypes) {
            int curBox = Math.min(truckSize, boxType[0]);
            int curUnit = curBox * boxType[1];
            ans += curUnit;

            truckSize -= curBox;
            if (truckSize == 0) {
                break;
            }
        }
        return ans;
    }
}
