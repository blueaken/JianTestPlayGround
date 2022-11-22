package lintcode.prefixsum.twodimension;

public class MatrixBlockSum_LE_1314 {
    /**
     ref 东哥 post
     - similar to 304.
     - presum 2d type
     */
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        //build the 2d ps array matrix
        int[][] ps = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                ps[i][j] = ps[i-1][j] + ps[i][j-1] + mat[i-1][j-1] - ps[i-1][j-1];
            }
        }

        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x1 = Math.max(i-k, 0);
                int y1 = Math.max(j-k, 0);

                int x2 = Math.min(i+k, m-1);
                int y2 = Math.min(j+k, n-1);

                res[i][j] = ps[x2+1][y2+1] - ps[x1][y2+1] - ps[x2+1][y1] + ps[x1][y1];
            }
        }

        return res;
    }
}
