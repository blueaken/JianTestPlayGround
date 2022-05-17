package lintcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class NumIslands_LE_200 {
    /*
        Idea - BFS, traverse the grid, explore each island element, mark all its neighbor island element to water element, and count;
    */
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int row, int col) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(row, col));
        while (queue.size() > 0) {
            Point cur = queue.poll();
            grid[cur.x][cur.y] = '0';
            for (int i = 0; i < 4; i++) {
                int newrow = cur.x + dx[i];
                int newcol = cur.y + dy[i];
                if (newrow >= 0 && newrow < grid.length && newcol >= 0 && newcol < grid[0].length && grid[newrow][newcol] == '1'){
                    queue.offer(new Point(newrow, newcol));
                }
            }
        }
    }

    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        NumIslands_LE_200 solution = new NumIslands_LE_200();
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(solution.numIslands(grid));
    }
}
