package lintcode.dfs.island;

public class NumIslands_LE_200_DFS {
    /*
        Idea
        - BFS, traverse the grid, explore each island element, mark all its neighbor island element to water element, and count; Got TLE; Try DFS;
        - DFS, similar to BFS, using recursive
    */
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (row < 0 || row == grid.length || col < 0 || col == grid[0].length || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < 4; i++) {
            dfs(grid, row + dx[i], col + dy[i]);
        }
    }
}
