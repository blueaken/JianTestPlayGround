package lintcode.dfs.island;

public class NumIslands_LE_200_DFS_P1 {
    /*
        Idea
        - BFS, traverse the grid, explore each island element, mark all its neighbor island element to water element, and count; Got TLE; Time - O(M * N), M - row numbers, N - col numbers, Space - O(Min(M, N)), refer https://imgur.com/gallery/M58OKvB
        - DFS, similar to BFS, Time - O(M * N), M - row numbers, N - col numbers, Space - O(M * N), in worst case, every cell is island, dfs travers all cells
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

    public static void main(String[] args) {
        NumIslands_LE_200_DFS_P1 solution = new NumIslands_LE_200_DFS_P1();
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(solution.numIslands(grid));
    }
}
