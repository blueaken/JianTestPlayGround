package ninechapter_algorithm.chapter4_dynamic_prgramming_1.uniquepath.third;

/**
 * Author: blueaken
 * Date: 7/1/16 13:03
 */
public class Solution {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here
        int[][] matrix = new int[m + 1][n + 1];

        //init
        for (int i = 1; i <= m; i++) {
            matrix[i][1] = 1;
        }
        for (int i = 1; i <= n; i++) {
            matrix[1][i] = 1;
        }

        //dp
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
            }
        }
        return matrix[m][n];
    }
}
