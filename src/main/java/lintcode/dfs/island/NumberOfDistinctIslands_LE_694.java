package lintcode.dfs.island;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands_LE_694 {
    /**
     1.12.2023
     ref 东哥 island post
     distinct island 相当于对序列化后相同字符串，巧妙
     */
    public int numDistinctIslands(int[][] grid) {
        Set<String> islands = new HashSet<>();

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, 999);
                    islands.add(sb.toString());
                }
            }
        }

        return islands.size();
    }

    private void dfs(int[][] grid, int i, int j, StringBuilder sb, int dir) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }

        if (grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;
        sb.append(dir).append(',');
        dfs(grid, i+1, j, sb, 1);
        dfs(grid, i-1, j, sb, 2);
        dfs(grid, i, j+1, sb, 3);
        dfs(grid, i, j-1, sb, 4);
        sb.append(-dir).append(',');
    }
}
