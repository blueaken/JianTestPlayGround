package lintcode.greedy;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumNumberOfRefuelingStops_LE_871 {
    /*
        ref huifeng guan's post
        - similar to jump game
        - solve with greedy
        - make target the last station of {target, 0}
    */
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        //case when no need any fuel
        if (startFuel >= target) {
            return 0;
        }

        int n = stations.length;
        //make target the last station
        int[][] nums = new int[n+1][2];
        for (int i = 0; i < n; i++) {
            nums[i] = stations[i];
        }
        nums[n] = new int[] {target, 0};

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        int curStationId = 0, count = 0;
        int curFuel = startFuel;
        while (curStationId < nums.length) {
            if (curFuel >= nums[curStationId][0]) {
                heap.offer(nums[curStationId][1]);
                curStationId++;
            } else {
                while(curFuel < nums[curStationId][0] && heap.size() > 0) {
                    curFuel += heap.poll(); //add the largest fuel of the passing stations
                    count++;
                }
                if (curFuel < nums[curStationId][0] && heap.size() == 0) {
                    return -1;
                }
            }
        }
        return count;
    }
}
