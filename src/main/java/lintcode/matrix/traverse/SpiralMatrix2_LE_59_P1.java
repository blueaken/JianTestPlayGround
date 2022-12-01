package lintcode.matrix.traverse;

public class SpiralMatrix2_LE_59_P1 {
    /**
     P1 12.01.2022
     ref prev notes and labuladong post
     */
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int upper_bound = 0, bottom_bound = n-1;
        int left_bound = 0, right_bound = n-1;

        int num = 1;
        while (num <= n*n) {
            // if (upper_bound <= bottom_bound) {
            for (int j = left_bound; j <= right_bound; j++) {
                res[upper_bound][j] = num++;
            }
            upper_bound++;
            // }

            // if (left_bound <= right_bound) {
            for (int i = upper_bound; i <= bottom_bound; i++) {
                res[i][right_bound] = num++;
            }
            right_bound--;
            // }

            // if (upper_bound <= bottom_bound) {
            for (int j = right_bound; j >= left_bound; j--) {
                res[bottom_bound][j] = num++;
            }
            bottom_bound--;
            // }

            // if (left_bound <= right_bound) {
            for (int i = bottom_bound; i >= upper_bound; i--) {
                res[i][left_bound] = num++;
            }
            left_bound++;
            // }

        }
        return res;
    }
}
