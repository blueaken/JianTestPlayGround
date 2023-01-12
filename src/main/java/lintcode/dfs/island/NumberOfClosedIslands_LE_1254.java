package lintcode.dfs.island;

public class NumberOfClosedIslands_LE_1254 {
    /**
     1.12.2023
     - similar to le 200, diff is surrounded edges does not count as land
     */
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int j = 0; j < n; j++) {
            // flood top edge
            dfs(grid, 0, j);
            // flood bottom edge
            dfs(grid, m-1, j);
        }
        for (int i = 0; i < n; i++) {
            // flood left edge
            dfs(grid, i, 0);
            // flood right edge
            dfs(grid, i, n-1);
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }

        if (grid[i][j] == 1) {
            return;
        }

        grid[i][j] = 1;
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}
