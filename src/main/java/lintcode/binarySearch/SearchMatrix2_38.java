package lintcode.binarySearch;

public class SearchMatrix2_38 {
    /**
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        //Idea 1: 每行分别使用BS，最后汇总，时间复杂度O（mlogN）
        // if (matrix.length == 0 || matrix[0].length == 0) {
        //     return 0;
        // }

        // int row = matrix.length;
        // int col = matrix[0].length;
        // int count = 0;
        // for (int i = 0; i < row; i++) {
        //     int start = 0, end = col - 1;
        //     while (start < end) {
        //         int mid = start + (end - start) / 2;
        //         if (matrix[i][mid] < target) {
        //             start = mid + 1;
        //         } else {
        //             end = mid;
        //         }
        //     }
        //     if (matrix[i][start] == target) {
        //         count++;
        //     }
        // }
        // return count;

        //Idea 2: 利用这个矩阵的3个特点从左下角开始搜索，向右上角逼近 O(m+n)
        // - Integers in each row are sorted from left to right
        // - Integers in each column are sorted from up to bottom
        // - No duplicate integers in each row or column.
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int row = matrix.length - 1;
        int col = 0;
        int count = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == target) {
                count++;
                row--;
                col++;
                continue;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                row--;
            }
        }
        return count;
    }
}
