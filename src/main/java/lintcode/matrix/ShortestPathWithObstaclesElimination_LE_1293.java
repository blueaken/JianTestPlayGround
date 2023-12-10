package lintcode.matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathWithObstaclesElimination_LE_1293 {
    /**
     12.10.23
     - try BFS, the difference is to there is multiple pssible for each obstacle, Time is O(MNK)
     - ref https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/solutions/1188835/java-clean-o-mnk-time-bfs-solution-comparing-with-dijkstra-s/
     */
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0,0,0}); //each grid has triple element - x, y, k
        // visited stored the current k value of each grid
        int[][] visited = new int[m][n];
        for (int[] arr : visited) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        visited[0][0] = 0;

        int step = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur[0] == m-1 && cur[1] == n-1) {
                    return step;
                }

                for (int j = 0; j < 4; j++) {
                    int newX = cur[0] + dirs[j][0];
                    int newY = cur[1] + dirs[j][1];

                    // check out of bound
                    if (newX < 0 || newX >= m || newY < 0 || newY >= n){
                        continue;
                    }

                    int newK = cur[2] + grid[newX][newY];
                    // check if out of elimination
                    if (newK > k) {
                        continue;
                    }

                    // check if have more optimal way to reach grid[newX][newY]
                    if (visited[newX][newY] <= newK) {
                        continue;
                    }

                    queue.add(new int[]{newX, newY, newK});
                    visited[newX][newY] = newK;
                }
            }
            step++;
        }
        return -1;
    }
}
