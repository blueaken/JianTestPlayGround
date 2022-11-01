package lintcode.heap;

import java.util.PriorityQueue;

public class MinCostConnectSticks_LE_1167_P2 {
    /*
        - P1
        - with the help of heap, since we need to keep merging the 2 shortest and the middle result need to be put back to heap
        ======================
        P2 11.01.2022
        ======================
    */
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int n = sticks.length;
        for (int i = 0; i < n; i++) {
            heap.offer(sticks[i]);
        }

        int ans = 0;
        while (heap.size() > 1) {
            int s1 = heap.poll();
            int s2 = heap.poll();
            int cur = s1 + s2;
            ans += cur;

            heap.offer(cur);
        }
        return ans;
    }
}
