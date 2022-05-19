package lintcode.heap;

import java.util.PriorityQueue;

public class MinCostConnectSticks_LE_1167 {
    /*
        follow the problem descriptioin,
        also ref - https://leetcode.com/problems/minimum-cost-to-connect-sticks/solution/
     */
    public int connectSticks(int[] sticks) {
        if (sticks == null || sticks.length < 2) {
            return 0;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < sticks.length; i++) {
            minHeap.offer(sticks[i]);
        }
        int totalcost = 0;
        while (minHeap.size() > 1) {
            int stick1 = minHeap.poll();
            int stick2 = minHeap.poll();

            int cost = stick1 + stick2;
            totalcost += cost;

            minHeap.offer(stick1 + stick2);
        }
        return totalcost;
    }
}
