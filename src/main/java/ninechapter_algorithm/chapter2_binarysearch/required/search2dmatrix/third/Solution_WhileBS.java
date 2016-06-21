package ninechapter_algorithm.chapter2_binarysearch.required.search2dmatrix.third;

/**
 * Author: blueaken
 * Date: 6/21/16 09:57
 */
public class Solution_WhileBS {
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
            int mid = (start + end) / 2;
            if (matrix[mid / col][mid % col] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return matrix[start / col][start % col] == target;
    }
}
