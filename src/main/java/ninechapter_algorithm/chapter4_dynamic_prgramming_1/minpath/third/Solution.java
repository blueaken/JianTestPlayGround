package ninechapter_algorithm.chapter4_dynamic_prgramming_1.minpath.third;

/**
 * Author: blueaken
 * Date: 7/1/16 16:00
 */
public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        if (grid == null || grid[0] == null) {
            return 0;
        }

        //init
        int row = grid.length;
        int col = grid[0].length;
        int[][] res = new int[row][col];
        res[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            res[i][0] = grid[i][0] + res[i - 1][0];
        }
        for (int i = 1; i < col; i++) {
            res[0][i] = grid[0][i] + res[0][i -1];
        }

        //dp
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                res[i][j] = grid[i][j] + Math.min(res[i - 1][j], res[i][j - 1]);
            }
        }
        return res[row - 1][col -1];
    }

}
