package ninechapter_algorithm.chapter2_binarysearch.optional.search2dmatrix2;

/**
 * Author: blueaken
 * Date: 4/13/16 5:30 PM
 */
public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        int count = 0;
        if (matrix == null || matrix.length == 0
                || matrix[0] == null || matrix[0].length == 0) {
            return count;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            int start = 0;
            int end = col - 1;
            while (start < end) {
                int mid = (start + end) / 2;
                if (matrix[i][mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            if (matrix[i][start] == target) {
                count++;
            }
        }

        return count;
    }
}
