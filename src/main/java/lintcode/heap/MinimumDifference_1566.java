package lintcode.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumDifference_1566 {
    /**
     * @param array: a 2D array
     * @return: the minimum difference
     */
    //Note: 题目要求对Min Diff的定义不是很清晰，描述说 max - min，对max和min又没有一个定义。参考答案中的算法Max是指选择需要是任意一列
    //中的最大值，Min指任意一列中最小值。根据这个定义, 得到下面Solutioin. Ref - https://www.lintcode.com/problem/1566/solution/29863
    public int minimumDifference(int[][] array) {
        // Write your code here
        int m = array.length;
        if (m == 0) return 0;
        int n = array[0].length;

        int total = m * n;

        Queue<Point> minHeap = new PriorityQueue<>((Point a, Point b) -> a.val - b.val);
        int max = Integer.MIN_VALUE;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            minHeap.offer(new Point(i, 0, array[i][0]));
            max = Math.max(max, array[i][0]);
        }
        minDiff = Math.min(minDiff, Math.abs(max - minHeap.peek().val));

        int count = m;
        while (count < total) {
            Point cur = minHeap.poll();
            if (cur.col == n - 1) {
                break;
            }
            minHeap.offer(new Point(cur.row, cur.col + 1, array[cur.row][cur.col+1]));
            max = Math.max(max, array[cur.row][cur.col+1]);
            minDiff = Math.min(minDiff, Math.abs(max - minHeap.peek().val));
            count++;
        }
        return minDiff;
    }
}

class Point {
    int row;
    int col;
    int val;
    Point (int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}
