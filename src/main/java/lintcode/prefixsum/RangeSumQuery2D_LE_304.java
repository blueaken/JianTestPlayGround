package lintcode.prefixsum;

public class RangeSumQuery2D_LE_304 {
    /**
     11.22.2022
     - ref 东哥 post
     - solve with presum & 矩阵本身特点
     */

    int[][] ps;
    public RangeSumQuery2D_LE_304(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        ps = new int[m+1][n+1];
        //build ps matrix（从0,0开始到现在位置） with 矩形特点
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                ps[i][j] = ps[i-1][j] + ps[i][j-1] + matrix[i-1][j-1] - ps[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return ps[row2+1][col2+1] - ps[row1][col2+1] - ps[row2+1][col1] + ps[row1][col1];
    }
}
