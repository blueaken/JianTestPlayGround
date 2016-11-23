package ninechapter_algorithm.chapter8_data_structure.optional.maximalsquare;

/**
 * Author: blueaken
 * Date: 5/31/16 14:27
 */
public class Solution_DP {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0
                || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int maxLen = 0;
        //dp[i][j] stores the maxLen of current matrix i,j
        int[][]dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                }
                maxLen = Math.max(dp[i][j], maxLen);
            }
        }
        return maxLen * maxLen;
    }

    public static void main(String[] args) {
        int test[][] = {
                {1},
                {1},
                {1}
        };

        Solution_DP solution = new Solution_DP();
        System.out.println(solution.maxSquare(test));
    }
}
