package ninechapter_algorithm.chapter2_binarysearch.required.search2dmatrix;

/**
 * Author: blueaken
 * Date: 2/23/16 11:01 AM
 */
public class Solution_OneBinarySearch {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        // Algorithm: Binary Search
        // Think the matrix as a linear array. The 1st element is at matrix[0][0],
        // the 2nd element is at matrix[0][1] ... the n*m-th element is a
        // matrix[n][m].
        // binary search in range 0 ~ (n*m - 1), calculate the coordinate from
        // the index.

        // check corner case
        /* your code */
        if (matrix == null || matrix.length == 0
                || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int rowNum = matrix.length;
        int colNum = matrix[0].length;

        // set binary search range
        int start = 0, end = rowNum*colNum-1;

        while (start < end) {
            int mid = (start + end) / 2;
            int row = mid / colNum;
            int col = mid % colNum;
            if (matrix[row][col] < target) {
                /* your code */
                start = mid + 1;
            } else {
                /* your code */
                end = mid;
            }
        }

        if (matrix[start/colNum][start%colNum] == target) {
            return true;
        }

        return false;
    }

    public static void main(String[] args){
        int test[][] = {
                { 1, 3, 5, 7},
                { 10, 11, 16, 20},
                { 23, 30, 34, 50}
        };

//        int target = 3;

        int target = 11;

//        int target = 34;

//        int target = 7;

//        int target = -3;

//        int target = 67;

        System.out.println(searchMatrix(test, target));
    }
}
