package ninechapter_algorithm.chapter4_dynamic_prgramming_1.uniquepath2.third;

/**
 * Author: blueaken
 * Date: 7/1/16 13:15
 */
public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if (obstacleGrid == null || obstacleGrid.length == 0
                || obstacleGrid[0] == null || obstacleGrid[0].length == 0) {
            return 0;
        }

        //init
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] path = new int[row][col];
        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            } else {
                path[i][0] = 1;
            }
        }
        for (int i = 0; i < col; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            } else {
                path[0][i] = 1;
            }
        }

        //dp
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                path[i][j] =
                        obstacleGrid[i][j] == 1 ? 0 : path[i-1][j] + path[i][j-1];

            }
        }
        return path[row - 1][col - 1];
    }
}
