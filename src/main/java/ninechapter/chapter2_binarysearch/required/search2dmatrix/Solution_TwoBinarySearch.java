package ninechapter.chapter2_binarysearch.required.search2dmatrix;

/**
 * Author: blueaken
 * Date: 2/22/16 4:49 PM
 */
public class Solution_TwoBinarySearch {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null
                || matrix.length == 0
                || matrix[0] == null
                || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int rowStart = 0;
        int rowEnd = row-1;
        int rowMid = 0;
        while (rowStart < rowEnd){
            rowMid = (rowStart + rowEnd) / 2;
            int cur = matrix[rowMid][0];
            if (cur > target){
                rowEnd = rowMid - 1;
            }else if (rowMid < rowEnd && target >= matrix[rowMid+1][0]){
                rowStart = rowMid + 1;
            }else {
                break;
            }
        }

        int rowIndex = (rowMid == rowEnd || rowMid < rowEnd && target < matrix[rowMid+1][0]) ? rowMid : rowStart;

        int colStart = 0;
        int colEnd = col-1;
        while (colStart < colEnd){
            int colMid = (colStart + colEnd) / 2;
            int cur = matrix[rowIndex][colMid];
            if (cur == target){
                return true;
            }else if(cur > target){
                colEnd = colMid - 1;
            }else{
                colStart = colMid + 1;
            }
        }

        return matrix[rowIndex][colStart] == target;
    }

    public static void main(String[] args){
        int test[][] = {
                { 1, 3, 5, 7},
                { 10, 11, 16, 20},
                { 23, 30, 34, 50}
        };

//        int target = 3;

//        int target = 11;

//        int target = 34;

//        int target = 7;

//        int target = -3;

        int target = 67;

        System.out.println(searchMatrix(test, target));
    }
}
