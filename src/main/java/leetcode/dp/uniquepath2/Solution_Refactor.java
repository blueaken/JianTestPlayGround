package leetcode.dp.uniquepath2;

/**
 * Created by jshe18 on 7/12/15.
 */
public class Solution_Refactor {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        if (row==0) return 0;
        int col = obstacleGrid[0].length;

        //better way to handle init
        int[][] path =  new int[row+1][col+1];
        path[0][1] = 1;

        for (int i=1; i<=row; i++){
            for (int j=1; j<=col; j++){
                if (obstacleGrid[i-1][j-1]==1){
                    path[i][j] = 0;
                }else{
                    path[i][j] = path[i][j-1] + path[i-1][j];
                }


            }
        }

        return path[row][col];
    }
}
