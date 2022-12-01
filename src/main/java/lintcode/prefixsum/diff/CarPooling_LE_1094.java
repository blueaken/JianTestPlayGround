package lintcode.prefixsum.diff;

public class CarPooling_LE_1094 {
    /**
     12.01.2022
     try solve with 差分数组
     - similar to 370 1109
     - some corner cases to handle
     - might solve with PriorityQueue like Meeting Room II.
     */
    public boolean carPooling(int[][] trips, int capacity) {
        int[] stops = new int[1001]; //ref to the data constraint
        for (int i = 0; i < trips.length; i++) {
            int start = trips[i][1];
            //drop off at stops trips[i][2], should count as leave in the previous stop
            int end = trips[i][2] - 1;
            int num = trips[i][0];

            stops[start] += num;
            if (end+1 < stops.length) {
                stops[end+1] -= num;
            }
        }

        //check 1st stop case
        if (stops[0] > capacity) {
            return false;
        }

        for (int i = 1; i < stops.length; i++) {
            stops[i] += stops[i-1];
            if (stops[i] > capacity) {
                return false;
            }
        }
        return true;
    }
}
