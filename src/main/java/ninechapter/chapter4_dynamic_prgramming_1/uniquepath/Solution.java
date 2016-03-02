package ninechapter.chapter4_dynamic_prgramming_1.uniquepath;

/**
 * Author: blueaken
 * Date: 3/2/16 2:56 PM
 */
public class Solution {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here
        if (m == 0 && n == 0) {
            return 0;
        }

        //init
        int[][] path = new int[m+1][n+1];
        path[0][1] = 1;

        //dp it
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                path[i][j] = path[i-1][j] + path[i][j-1];
            }
        }

        return path[m][n];
    }
}
