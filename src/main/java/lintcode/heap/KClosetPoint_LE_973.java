package lintcode.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosetPoint_LE_973 {
    /*
        use maxHeap, Time - O(NlogK), Space - O(K)
    */
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> getDistance(b) - getDistance(a));
        for (int i = 0; i < points.length; i++) {
            maxHeap.offer(points[i]);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll();
        }
        return res;
    }

    private int getDistance (int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public static void main(String[] args) {
        KClosetPoint_LE_973 solution = new KClosetPoint_LE_973();
        int[][] points = {{1,3},{-2,2}};
        int k = 1;
        //[[-2,2]]

        System.out.println(Arrays.deepToString(solution.kClosest(points, k)));
    }
}
