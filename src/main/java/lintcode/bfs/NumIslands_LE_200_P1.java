package lintcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class NumIslands_LE_200_P1 {
    /*
        Idea
        - BFS, traverse the grid, explore each island element, mark all its neighbor island element to water element, and count; Got TLE; Time - O(M * N), M - row numbers, N - col numbers, Space - O(Min(M, N)), refer https://imgur.com/gallery/M58OKvB
        - DFS, similar to BFS, using recursive
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

    private void bfs(char[][] grid, int i, int j) {

        class Point {
            int row;
            int col;
            Point(int row, int col) {
                this.row = row;
                this.col = col;
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(i, j));
        while (queue.size() > 0) {
            Point cur = queue.poll();
            grid[cur.row][cur.col] = '0';
            for (int k = 0; k < 4; k++) {
                int newrow = cur.row + dx[k];
                int newcol = cur.col + dy[k];

                if (newrow >= 0 && newrow < grid.length && newcol >= 0 && newcol < grid[0].length && grid[newrow][newcol] == '1') {
                    queue.offer(new Point(newrow, newcol));
                }
            }
        }
    }

    public static void main(String[] args) {
        NumIslands_LE_200_P1 solution = new NumIslands_LE_200_P1();
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(solution.numIslands(grid));
    }
}
