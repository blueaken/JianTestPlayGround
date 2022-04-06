package lintcode.dynamicprogramming2;

public class CountSquares_1869 {
    /**
     * @param matrix: a matrix
     * @return: return how many square submatrices have all ones
     */
    //ref - https://www.youtube.com/watch?v=_Lf1looyJMU
    public int countSquares(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0
                || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m+1][n+1];

        //dp
        int sum = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i-1][j-1] == 1) {
                    res[i][j] = 1+ Math.min(res[i][j-1], Math.min(res[i-1][j-1], res[i-1][j]));
                    sum += res[i][j]; //number of squares equals maxside of each position
                }
            }
        }
        return sum;
    }
}
