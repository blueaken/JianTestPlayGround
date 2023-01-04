package lintcode.heap;

import java.util.PriorityQueue;

public class KthSmallestElementInSortedMatrix_LE_378 {
    /**
     1.3.2023
     similar to 23 and 373, use heap to improve performance
     ref 东哥 post
     - 用binary search应该更加快，有空可以练习
     */
    public int kthSmallest(int[][] matrix, int k) {
        // int[] 存储{matrix[i][j], i, j}三元组
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < matrix.length; i++) {
            heap.offer(new int[] {matrix[i][0], i, 0});
        }

        int ans = -1;
        while (heap.size() > 0 && k > 0) {
            int[] cur = heap.poll();
            ans = cur[0];
            k--;
            int nextI = cur[1];
            int nextJ = cur[2] + 1;
            if (nextJ < matrix[0].length) {
                heap.offer(new int[] {matrix[nextI][nextJ], nextI, nextJ});
            }
        }
        return ans;
    }
}
