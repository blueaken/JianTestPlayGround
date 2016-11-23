package ninechapter_algorithm.chapter9_graphic.optional.numberofislands;

/**
 * Author: blueaken
 * Date: 6/16/16 18:39
 */
public class Solution_DFS {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        // Write your code here
        int count = 0;
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) {
                    removeIsland(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void removeIsland(boolean[][]grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || !grid[i][j]) {
            return;
        }

        grid[i][j] = false;
        removeIsland(grid, i - 1, j);
        removeIsland(grid, i + 1, j);
        removeIsland(grid, i, j - 1);
        removeIsland(grid, i, j + 1);
        return;
    }
}
