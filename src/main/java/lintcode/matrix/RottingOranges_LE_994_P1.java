package lintcode.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges_LE_994_P1 {
    //bfs - refactor with for loop
    //note the minutes init to -1
    //Time - O(N^2), ref - https://leetcode.com/problems/rotting-oranges/solution/
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                if (grid[i][j] != 0) {
                    total++;
                }
            }
        }

        int remain = total - queue.size();
        //case when all oranges are rotten
        if (remain == 0) {
            return 0;
        }
        //case when all oranges are healthy
        if (queue.size() == 0) {
            return -1;
        }

        int minutes = -1;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        //start bfs
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int row = cur[0];
                int col = cur[1];
                for (int j = 0; j < 4; j++) {
                    int newrow = row + dx[j];
                    int newcol = col + dy[j];
                    if (newrow < 0 || newrow >= grid.length || newcol < 0 || newcol >= grid[0].length
                            || grid[newrow][newcol] != 1) {
                        continue;
                    }
                    grid[newrow][newcol] = 2;
                    remain--;
                    queue.offer(new int[]{newrow, newcol});
                }
            }
            minutes++;
        }

        return remain == 0 ? minutes : -1;
    }
}
