package lintcode.matrix;

import java.util.*;
public class ShortestPathWithObstaclesElimination_LE_1293_Dijkstra {
    /**
     12.10.23
     - try BFS, the difference is to there is multiple pssible for each obstacle, Time is O(MNK)
     - ref https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/solutions/1188835/java-clean-o-mnk-time-bfs-solution-comparing-with-dijkstra-s/
     - try Dijkstra
     */
    class State {
        int x, y, obstacleCount, dist;

        State(int x, int y, int obstacleCount, int dist) {
            this.x = x;
            this.y = y;
            this.obstacleCount = obstacleCount;
            this.dist = dist;
        }
    }

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        int[][][] distTo = new int[m][n][k+1];
        for (int[][] dists : distTo) {
            for (int[] dist : dists) {
                Arrays.fill(dist, Integer.MAX_VALUE);
            }
        }
        Arrays.fill(distTo[0][0], 0);

        PriorityQueue<State> heap = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        heap.offer(new State(0,0,0,0));

        while (heap.size() > 0) {
            State cur = heap.poll();
            int x = cur.x;
            int y = cur.y;
            int obstacleCount = cur.obstacleCount;
            int dist = cur.dist;

            if (x == m-1 && y == n-1) {
                continue;
            }

            for (int j = 0; j < 4; j++) {
                int newX = x + dirs[j][0];
                int newY = y + dirs[j][1];

                // check out of bound
                if (newX < 0 || newX >= m || newY < 0 || newY >= n){
                    continue;
                }

                int newK = obstacleCount + grid[newX][newY];
                // check if out of elimination
                if (newK > k) {
                    continue;
                }

                int newDist = dist + 1;
                // check if have optimal ways to reach grid[newX][newY]
                if (distTo[newX][newY][newK] <= newDist) continue;

                distTo[newX][newY][newK] = newDist;
                heap.offer(new State(newX, newY, newK, newDist));

            }

        }

        int res = distTo[m-1][n-1][0];
        for (int i = 1; i <= k; i++) res = Math.min(res, distTo[m-1][n-1][i]);
        return (res == Integer.MAX_VALUE) ? -1 : res;

    }
}
