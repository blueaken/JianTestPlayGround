package ninechapter_algorithm.chapter2_binarysearch.required.search2dmatrix.second;

/**
 * Author: blueaken
 * Date: 4/12/16 10:12 AM
 */
public class Solution_WholeBS {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0
                || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int start = 0;
        int end = row * col - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid/col][mid%col] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return matrix[start/col][start%col] == target;
    }
}
