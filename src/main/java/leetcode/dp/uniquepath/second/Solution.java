package leetcode.dp.uniquepath.second;

/**
 * Author: blueaken
 * Date: 11/14/15 9:02 PM
 */
public class Solution {
    //grid[i][j] = grid[i-1][j] + grid[i][j-1]
    public static int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];

        //set initial values on the borders
        for (int i=0; i<m; i++){
            grid[i][0] = 1;
        }
        for (int i=0; i<n; i++){
            grid[0][i] = 1;
        }

        //apply the DP formula
        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                grid[i][j] = grid[i-1][j] + grid[i][j-1];
            }
        }

        return grid[m-1][n-1];
    }

    public static void main(String[] args){
        System.out.println(uniquePaths(3,3));
    }
}
