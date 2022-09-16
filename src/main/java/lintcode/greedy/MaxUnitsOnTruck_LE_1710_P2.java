package lintcode.greedy;

import java.util.PriorityQueue;

public class MaxUnitsOnTruck_LE_1710_P2 {
    /*
        P2
        - heap with greedy
    */
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int[] boxType : boxTypes) {
            maxHeap.offer(boxType);
        }

        int ans = 0;
        while (maxHeap.size() > 0) {
            int[] cur = maxHeap.poll();
            int curNum = Math.min(cur[0], truckSize);
            ans += curNum * cur[1];

            truckSize -= curNum;
            if (truckSize == 0) {
                break;
            }
        }

        return ans;
    }
}
