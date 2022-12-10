package lintcode.binarysearch.labuladong.variant;

public class Search2DMatrix2_LE_240 {
    /**
     12.10.2022
     ref 东哥 post - 从右上角开始，向下是增加，向左是减少
     O(m+n)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m =  matrix.length;
        int n = matrix[0].length;

        int i = 0, j = n-1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
