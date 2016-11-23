package leetcode.algorithm.dp.uniquepath2;

/**
 * Created by jshe18 on 7/12/15.
 */
public class Solution {
    //DP - Time O(mn), Space O(mn)
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        //return 0 if the obstacle is at the start point
        if (obstacleGrid[0][0]==1) return 0;

        //init the path values, same as unique path 1 besides mark the obstacle position as 0
        for (int i=0; i<row; i++){
            if (obstacleGrid[i][0]==0) {
                obstacleGrid[i][0]=1;
            } else {
                for (int j=i; j<row; j++) {
                    obstacleGrid[j][0] = 0;
                }
                break;
            }
        }
        for (int i=1; i<col; i++){
            if (obstacleGrid[0][i]==0) {
                obstacleGrid[0][i]=1;
            } else {
                for (int j=i; j<col; j++) {
                    obstacleGrid[0][j] = 0;
                }
                break;
            }
        }

        for (int i=1; i<row; i++){
            for (int j=1; j<col; j++){
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else
                {
                    obstacleGrid[i][j] = obstacleGrid[i][j-1] + obstacleGrid[i-1][j];
                }
            }
        }

        return obstacleGrid[row-1][col-1];

    }

}
