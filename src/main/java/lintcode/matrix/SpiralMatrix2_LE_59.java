package lintcode.matrix;

import java.util.Arrays;

public class SpiralMatrix2_LE_59 {
    //ref - https://leetcode.com/problems/spiral-matrix-ii/discuss/22289/My-Super-Simple-Solution.-Can-be-used-for-both-Spiral-Matrix-I-and-II
    //better than solution, Time - O(N), N - the number of cells
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0) {
            return matrix;
        }

        //init
        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;
        int num = 1; // keep change

        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                matrix[rowStart][i] = num++;
            }
            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++) {
                matrix[i][colEnd] = num++;
            }
            colEnd--;

            for (int i = colEnd; i >= colStart; i--) {
                matrix[rowEnd][i] = num++;
            }
            rowEnd--;

            for (int i = rowEnd; i >= rowStart; i--) {
                matrix[i][colStart] = num++;
            }
            colStart++;
        }
        return matrix;
    }

    public static void main(String[] args) {
        SpiralMatrix2_LE_59 solution = new SpiralMatrix2_LE_59();
//        int n = 3;//[[1, 2, 3], [8, 9, 4], [7, 6, 5]]
//        int n = 1;//[[1]]
        int n = 5;//[[1, 2, 3, 4, 5], [16, 17, 18, 19, 6], [15, 24, 25, 20, 7], [14, 23, 22, 21, 8], [13, 12, 11, 10, 9]]

        System.out.println(Arrays.deepToString(solution.generateMatrix(n)));
    }
}
