package lintcode.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxUnitsOnTruck_LE_1710 {
    /*
        Idea: first thought it is a BackPack DP problem, then found each type of box size is not fixed, ref solution page, follow the greedy algorithm, and Priority Queue solution - https://leetcode.com/problems/maximum-units-on-a-truck/solution/

        Time: O(NLogN) building the heap, Space: O(1)
    */
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        heap.addAll(Arrays.asList(boxTypes));
        int remainSize = truckSize;
        int res = 0;

        while (heap.size() > 0) {
            int[] curMaxBoxType = heap.poll();
            int unitSize = Math.min(curMaxBoxType[0], remainSize);
            res += unitSize * curMaxBoxType[1];

            //update the remainSize
            remainSize -= unitSize;
            if (remainSize == 0) {
                break;
            }
            //not need to mark curBoxType as used, since it is alreay out of heap

        }
        return res;
    }

    public static void main(String[] args) {
        MaxUnitsOnTruck_LE_1710 solution = new MaxUnitsOnTruck_LE_1710();
        int[][]boxTypes = {{1,3},{2,2},{3,1}};
        int truckSize = 4;
        //expect 8

        System.out.println(solution.maximumUnits(boxTypes, truckSize));
    }
}
