package ninechapter.chapter4_dynamic_prgramming_1.minpath;

/**
 * Author: blueaken
 * Date: 3/2/16 10:32 AM
 */
public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public static int minPathSum(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0) {
            return -1;
        }
        if (grid[0] == null || grid[0].length == 0) {
            return -1;
        }

        int row = grid.length;
        int col = grid[0].length;
        int min[][] = new int[row][col];

        //init and dp together
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    min[0][0] = grid[0][0];
                } else if (i == 0 && j > 0) {
                    min[0][j] = grid[0][j] + min[0][j-1];
                } else if (i > 0 && j == 0) {
                    min[i][0] = grid[i][0] + min[i-1][0];
                } else {
                    min[i][j] = grid[i][j] + Math.min(min[i-1][j], min[i][j-1]);
                }

            }
        }

        return min[row-1][col-1];
    }

    public static void main(String[] args) {
        int test[][] = {
                { 1, 3, 1},
                { 1, 5, 1},
                { 4, 2, 1}
        };

        System.out.println(minPathSum(test));
    }
}
