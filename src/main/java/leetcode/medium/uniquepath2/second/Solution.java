package leetcode.medium.uniquepath2.second;

import leetcode.Util;

/**
 * Author: blueaken
 * Date: 11/15/15 9:57 AM
 */
public class Solution {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        if (row==0) return 0;
        int col = obstacleGrid[0].length;

        int[][] grid = new int[row+1][col+1];
        grid[0][1] =1;
        for (int i=1; i<row+1; i++){
            for (int j=1; j<col+1; j++){
                grid[i][j] = obstacleGrid[i-1][j-1]==1 ? 0: grid[i-1][j] + grid[i][j-1];
            }
        }

        return grid[row][col];
    }

    public static void main(String[] args){
        int row = 3;
        int col = 3;

        int[][] testGrid1 = new int[row][col];

        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if ((i==0 && j==1)) {
                    testGrid1[i][j] = 1;
                } else{
                    testGrid1[i][j] = 0;
                }
            }
        }

        //print the grid
        Util.printGrid(testGrid1);

        System.out.println("The result is: " + uniquePathsWithObstacles(testGrid1));

    }
}
