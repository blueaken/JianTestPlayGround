package ninechapter.chapter4_dynamic_prgramming_1.uniquepath2;

/**
 * Author: blueaken
 * Date: 3/2/16 3:12 PM
 */
public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        //init
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] path = new int[row+1][col+1];
        path[0][1] = 1;

        //dp it
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (obstacleGrid[i-1][j-1] == 1) {
                    continue;
                }
                path[i][j] = path[i-1][j] + path[i][j-1];
            }
        }

        return path[row][col];
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
