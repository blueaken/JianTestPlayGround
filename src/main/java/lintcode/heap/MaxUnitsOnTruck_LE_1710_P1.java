package lintcode.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxUnitsOnTruck_LE_1710_P1 {
    //boxTypes[i] = [numberOfBoxes, numberOfUnitsPerBoxi]
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        heap.addAll(Arrays.asList(boxTypes));
        int remainingSize = truckSize;
        int ans = 0;
        while (heap.size() > 0) {
            int[] curBoxType = heap.poll();
            int unitSize = Math.min(curBoxType[0], remainingSize);
            ans += unitSize * curBoxType[1];

            remainingSize -= unitSize;
            if (remainingSize == 0) {
                break;
            }
        }
        return ans;
    }
}
