package ninechapter_algorithm.chapter4_dynamic_prgramming_1.uniquepath.second;

/**
 * Author: blueaken
 * Date: 4/6/16 9:01 AM
 */
public class Solution {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here
        int[][] res = new int[m][n];

        //init
        for (int i = 0; i < m; i++){
            res[i][0] = 1;
        }
        for (int i = 1; i < n; i++){
            res[0][i] = 1;
        }

        //dp
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                res[i][j] = res[i-1][j] + res[i][j-1];
            }
        }

        return res[m-1][n-1];
    }
}
