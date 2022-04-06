package lintcode.dynamicprogramming2;

public class MaximalSquare_LE_221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0
                || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m+1][n+1];

        //dp
        int maxSide = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i-1][j-1] == '1') {
                    res[i][j] = 1 + Math.min(res[i][j-1], Math.min(res[i-1][j-1], res[i-1][j]));
                    maxSide = Math.max(maxSide, res[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }

    public static void main(String[] args) {
        char[][] input = {{'0','0','1','1','1'}, {'1','0','1','1','1'}, {'0','1','1','1','1'}, {'1','0','1','1','1'}};

        MaximalSquare_LE_221 solution = new MaximalSquare_LE_221();
        System.out.println(solution.maximalSquare(input));
    }
}
