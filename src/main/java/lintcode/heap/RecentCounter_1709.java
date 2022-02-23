package lintcode.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class RecentCounter_1709 {
    private Queue<Integer> heap;

    public RecentCounter_1709() {
        heap = new PriorityQueue<Integer>();
    }

    public int ping(int t) {
        heap.offer(t);
        while (heap.size() > 0 && heap.peek() < (t - 3000)) {
            heap.poll();
        }
        return heap.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */