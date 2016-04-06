package ninechapter_algorithm.chapter4_dynamic_prgramming_1.minpath.second;

/**
 * Author: blueaken
 * Date: 4/6/16 10:05 AM
 */
public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public static int minPathSum(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        //init
        int row = grid.length;
        int col = grid[0].length;
        int res[][] = new int[row][col];
        res[0][0] = grid[0][0];
        for (int i = 1; i < row; i++){
            res[i][0] = grid[i][0] + res[i-1][0];
        }
        for (int i = 1; i < col; i++){
            res[0][i] = grid[0][i] + res[0][i-1];
        }

        //dp
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                res[i][j] = Math.min(res[i-1][j], res[i][j-1]) + grid[i][j];
            }
        }

        return res[row-1][col-1];
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
