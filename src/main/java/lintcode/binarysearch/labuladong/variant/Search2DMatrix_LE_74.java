package lintcode.binarysearch.labuladong.variant;

public class Search2DMatrix_LE_74 {
    /**
     12.09.2022
     - ref 东哥 post
     - convert the index to 1d array and solve by BS template
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cur = getVal(matrix, mid);
            if ( cur == target) {
                return true;
            } else if (cur < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    private int getVal(int[][] matrix, int index) {
//        int m = matrix.length;
        int n = matrix[0].length;

        int row = index / n;
        int col = index % n;
        return matrix[row][col];
    }
}
