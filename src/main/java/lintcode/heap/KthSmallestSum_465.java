package lintcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestSum_465 {
    /**
     * @param A: an integer arrays sorted in ascending order
     * @param B: an integer arrays sorted in ascending order
     * @param k: An integer
     * @return: An integer
     */
    //Idea: similar to 401 Kth Smallest Number in Sorted Matrix, using minHeap to improve Time Complexity
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // write your code here
        int lenA = A.length;
        int lenB = B.length;

        boolean[][] visited = new boolean [lenA][lenB];
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>(k, new PairComparator());
        minHeap.offer(new Pair(0, 0, A[0] + B[0]));

        //循环k-1次，则第k小的元素在堆首
        for (int i = 0; i < k - 1; i++) {
            Pair cur = minHeap.poll();
            int newAPos = cur.aPos + 1;
            if (newAPos < lenA && !visited[newAPos][cur.bPos]) {
                minHeap.offer(new Pair(newAPos, cur.bPos, A[newAPos] + B[cur.bPos]));
                visited[newAPos][cur.bPos] = true;
            }
            int newBPos = cur.bPos + 1;
            if (newBPos < lenB && !visited[cur.aPos][newBPos]) {
                minHeap.offer(new Pair(cur.aPos, newBPos, A[cur.aPos] + B[newBPos]));
                visited[cur.aPos][newBPos] = true;
            }
        }
        return minHeap.peek().sum;
    }

    class Pair {
        int aPos;
        int bPos;
        int sum;
        Pair (int aPos, int bPos, int sum) {
            this.aPos = aPos;
            this.bPos = bPos;
            this.sum = sum;
        }
    }

    class PairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair a, Pair b) {
            return a.sum - b.sum;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 7, 11};
        int[] b = {2, 4, 6};
        int k = 3;

//        int[] a = {1, 2, 3, 4};
//        int[] b = {1, 2, 3, 4};
//        int k = 15;

        KthSmallestSum_465 solution = new KthSmallestSum_465();
        System.out.println(solution.kthSmallestSum(a, b, k));
    }
}
