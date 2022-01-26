package lintcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallest_401 {
    /**
     * @param matrix: a matrix of integers
     * @param k: An integer
     * @return: the kth smallest number in the matrix
     */
    //Idea: 可以遍历matrix，再排序找第K小数，但这样是O(nm)，可以通过minHeap来实现O(klogn)。
    //Ref - https://www.lintcode.com/problem/401/solution/17967
    //O(klogn) - 因为heap每次poll操作O(logn)
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        int n = matrix.length;
        int m = matrix[0].length;
        int[] dx = new int[]{0,1};
        int[] dy = new int[]{1,0};

        boolean[][] visited = new boolean[n][m];
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>(k, new PairComparator());
        minHeap.offer(new Pair(0, 0, matrix[0][0]));
        //循环k-1次，则第k小的元素在堆首
        for (int i = 0; i < k - 1; i++) {
            Pair cur = minHeap.poll();
            //加2个方向的matrix值
            for (int j = 0; j < 2; j++) {
                int newx = cur.x + dx[j];
                int newy = cur.y + dy[j];
                //如果新方向matrix值存在，则加入minHeap中
                if (newx < n && newy < m && !visited[newx][newy]) {
                    minHeap.offer(new Pair(newx, newy, matrix[newx][newy]));
                    visited[newx][newy] = true;
                }
            }

        }
        return minHeap.peek().val;
    }

    class Pair {
        int x;
        int y;
        int val;
        Pair (int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    class PairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair a, Pair b) {
            return a.val - b.val;
        }
    }
}
