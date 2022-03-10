package lintcode.dynamicprogramming;

public class MinPathSum_110 {
    /**
     * @param grid: a list of lists of integers
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    //Idea: 参考以前nine chapter solution和https://www.lintcode.com/problem/110/solution/19866
    public int minPathSum(int[][] grid) {
        // write your code here
        if (grid == null || grid[0] == null) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        int[][] res = new int[row][col];

        //init
        res[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            res[i][0] = res[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < col; i++) {
            res[0][i] = res[0][i-1] + grid[0][i];
        }

        //dp
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                res[i][j] = grid[i][j] + Math.min(res[i-1][j], res[i][j-1]);
            }
        }

        return res[row-1][col-1];
    }
}
