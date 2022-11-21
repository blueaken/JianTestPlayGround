package lintcode.binarysearch;

public class SearchMatrix_28 {

    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    //Idea: 直接在矩阵中用1次BinarySearch可以避免分2次搜索需要处理中间情况
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix.length == 0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0, end = row * col - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid/col][mid%col] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return matrix[start/col][start%col] == target ? true : false;
    }


    public static void main(String[] args) {
        int[][] input = {{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 50}};
        int target = 2;

//        int[][] input = {{1}};
//        int target = -1;

        SearchMatrix_28 solution = new SearchMatrix_28();
        System.out.println(solution.searchMatrix(input, target));
    }
}
