package lintcode.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosetPoint_LE_973_P1 {
    /*
        - use maxHeap, Time - O(NlogK), Space - O(K)
        - refactor to remove the Pair class and get the result from heap toArray function directly.
    */
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(k, (a, b) -> getDistance(b) - getDistance(a));
        for (int i = 0; i < points.length; i++) {
            heap.offer(points[i]);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.toArray(new int[heap.size()][]);
    }

    private int getDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public static void main(String[] args) {
        KClosetPoint_LE_973_P1 solution = new KClosetPoint_LE_973_P1();
//        int[][] points = {{1,3},{-2,2}};
//        int k = 1;
//        //[[-2,2]]

        int[][] points = {{-5,4},{-6,-5},{4,6}};
        int k = 2;
        //[[-5,4],[4,6]]

        System.out.println(Arrays.deepToString(solution.kClosest(points, k)));
    }
}
