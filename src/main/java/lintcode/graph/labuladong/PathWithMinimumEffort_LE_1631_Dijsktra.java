package lintcode.graph.labuladong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PathWithMinimumEffort_LE_1631_Dijsktra {
    /**
     2.2.2023
     Dijkstra算法，ref 东哥 post
     */
    // 计算从(0,0) 到 (m-1, n-1)的最小effort
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        // 从(0,0) 到(i,j)最小effort时effortTo[i][j]
        int[][] effortTo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(effortTo[i], Integer.MAX_VALUE);
        }
        // base case
        effortTo[0][0] = 0;

        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> a.effortFromStart - b.effortFromStart);
        pq.offer(new State(0,0,0));

        while (pq.size() > 0) {
            State cur = pq.poll();
            int curX = cur.x;
            int curY = cur.y;
            int curEffortFromStart = cur.effortFromStart;

            // 找到了终点，返回
            if (curX == m-1 && curY == n-1) {
                return curEffortFromStart;
            }

            if (curEffortFromStart > effortTo[curX][curY]) {
                continue;
            }

            for (int[] next : adj(heights, curX, curY)) {
                int nextX = next[0];
                int nextY = next[1];
                int nextEffortFromStart = Math.max(
                        effortTo[curX][curY],
                        Math.abs(heights[curX][curY] - heights[nextX][nextY]));

                if (effortTo[nextX][nextY] > nextEffortFromStart) {
                    effortTo[nextX][nextY] = nextEffortFromStart;
                    pq.offer(new State(nextX, nextY, nextEffortFromStart));
                }
            }
        }
        // 应该不会访问到这里
        return -1;
    }

    // 返回坐标(x, y)周围的相邻坐标
    private List<int[]> adj(int[][] matrix, int x, int y) {
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int m = matrix.length, n = matrix[0].length;

        List<int[]> neighbors = new ArrayList<>();
        for (int k = 0; k < 4; k++) {
            int nx = x + dirs[k][0];
            int ny = y + dirs[k][1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                continue;
            }
            neighbors.add(new int[]{nx, ny});
        }
        return neighbors;
    }

    class State {
        // matrix中一个位置
        int x, y;
        int effortFromStart;

        State(int x, int y, int effortFromStart) {
            this.x = x;
            this.y = y;
            this.effortFromStart = effortFromStart;
        }
    }
}
