package lintcode.matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottingOranges_LE_994 {
    /*
        question is if there are multiple rotten oranges? assume there can be.
        kind of error prone - ref https://leetcode.com/problems/rotting-oranges/solution/,
        for each level - add (-1, -1) mark to avoid endless loop
    */
    public int orangesRotting(int[][] grid) {
        //count the total orange size
        int total = 0;
        List<Point> rottens = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    total++;
                }
                if (grid[i][j] == 2) {
                    Point point = new Point(i, j);
                    rottens.add(point);
                }
            }
        }

        //all rotten case
        if (rottens.size() == total) {
            return 0;
        }
        //no rotten case
        if (rottens.size() == 0) {
            return -1;
        }

        //bfs each rotten orange
        int minutes =  bfs(rottens, grid, rottens.size(), total);
        return minutes;
    }

    private int bfs(List<Point> rottens, int[][]grid, int rottenNum, int total) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        // load the first round / level
        Queue<Point> queue = new LinkedList<>();
        for (Point point : rottens) {
            queue.offer(point);
        }
        queue.offer(new Point(-1, -1));
        int minutes = -1;

        //bfs
        while (queue.size() > 0) {
            Point cur = queue.poll();
            int row = cur.x;
            int col = cur.y;
            if (row == -1) {
                //We finish one round of processing.
                minutes++;
                //to avoid the endless loop
                if (!queue.isEmpty()) {
                    queue.offer(new Point(-1, -1));
                }
            } else {
                //this is a rotten orange and would contaminates neighbors of 4 directions
                for (int i = 0; i < 4; i++) {
                    int newrow = row + dx[i];
                    int newcol = col + dy[i];
                    if (newrow >= 0 && newrow < grid.length && newcol >= 0 && newcol < grid[0].length && grid[newrow][newcol] == 1){
                        grid[newrow][newcol] = 2;
                        rottenNum++;
                        // this orange would then contaminate other oranges
                        queue.offer(new Point(newrow, newcol));
                    }
                }
            }
        }

        if (rottenNum == total) {
            return minutes;
        } else {
            return -1;
        }
    }

    class Point {
        int x;
        int y;

        Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        RottingOranges_LE_994 solution = new RottingOranges_LE_994();
//        int[][] grid = {{2,1,1}, {1,1,0}, {0,1,1}}; //4
        int[][] grid = {{2,1,1}, {1,1,1}, {0,1,2}}; //2

        System.out.println(solution.orangesRotting(grid));
    }
}
