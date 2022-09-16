package lintcode.heap;

import java.util.PriorityQueue;

public class KClosetPoint_LE_973_P2 {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> getDis(b) - getDis(a));
        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        return maxHeap.toArray(new int[maxHeap.size()][]);
    }

    private int getDis(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
