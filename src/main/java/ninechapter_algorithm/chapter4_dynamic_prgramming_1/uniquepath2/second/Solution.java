package ninechapter_algorithm.chapter4_dynamic_prgramming_1.uniquepath2.second;

/**
 * Author: blueaken
 * Date: 4/6/16 9:25 AM
 */
public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if (obstacleGrid == null || obstacleGrid.length == 0
                || obstacleGrid[0] == null || obstacleGrid[0].length == 0) {
            return 0;
        }

        //init
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] res = new int[row+1][col+1];
        res[0][1] = 1;

        //dp
        for (int i = 1; i <= row; i++){
            for (int j = 1; j <= col; j++){
                res[i][j] = obstacleGrid[i-1][j-1] == 1 ? 0 : res[i-1][j] + res[i][j-1];
            }
        }

        return res[row][col];
    }

    public static void main(String[] args) {
        int test[][] = {
                { 0, 0, 0},
                { 0, 1, 0},
                { 0, 0, 0}
        };

        System.out.println(uniquePathsWithObstacles(test));
    }
}
