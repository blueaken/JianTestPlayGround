package leetcode.dp.uniquepath.second;

/**
 * Author: blueaken
 * Date: 11/15/15 9:50 AM
 */
public class Solution_BetterInit {
    public static int uniquePaths(int m, int n) {
        int[][] grid = new int[m+1][n+1];
        grid[0][1] = 1;

        for(int i=1; i<m+1; i++){
            for (int j=1; j<n+1; j++){
                grid[i][j] = grid[i-1][j] + grid[i][j-1];
            }
        }

        return grid[m][n];
    }

    public static void main(String[] args){
        System.out.println(uniquePaths(3,3));
    }
}
