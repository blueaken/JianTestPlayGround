package leetcode.dp.uniquepath;

/**
 * Created by jshe18 on 7/12/15.
 */
public class Solution_Refactor {
    public int uniquePaths(int m, int n) {

        //better way to handle init
        int[][] path =  new int[m+1][n+1];
        path[0][1] = 1;

        for (int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){
                path[i][j] = path[i][j-1] + path[i-1][j];
            }
        }

        return path[m][n];
    }
}
