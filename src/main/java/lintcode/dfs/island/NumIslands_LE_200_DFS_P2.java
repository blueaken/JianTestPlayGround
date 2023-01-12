package lintcode.dfs.island;

public class NumIslands_LE_200_DFS_P2 {
    /*
        P2
    */
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        dfs(grid, i, j + 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i - 1, j);

        // int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // for (int k = 0; k < 4; k++) {
        //     dfs(grid, i + move[k][0], j + move[k][1]);
        // }
    }
}
