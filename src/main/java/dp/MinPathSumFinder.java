package dp;

/**
 * Author: blueaken
 * Date: 2/4/15 8:13 下午
 */
/*
* https://oj.leetcode.com/problems/minimum-path-sum/
*
* Find path 问题的一个变种，注意边界条件的检查
 */
public class MinPathSumFinder {
    public static void main(String[]args){
        int row = 3;
        int col = 3;

        int matrix[][] = new int[row][col];

        matrix[0][0] = 0;
        matrix[0][1] = 2;
        matrix[0][2] = 8;

        matrix[1][0] = 5;
        matrix[1][1] = 5;
        matrix[1][2] = 6;

        matrix[2][0] = 0;
        matrix[2][1] = 0;
        matrix[2][2] = 7;

        System.out.println("Min path sum is: " +
        findMinPathSum(matrix));

    }

    static int findMinPathSum(int[][] matrix){

        int row = matrix.length;
        int col = matrix[0].length;

        //for each node calculate the min sum of the path
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if (i==0 && j==0)
                    continue;
                else if (i==0 && j>0) {
                    matrix[0][j] = matrix[0][j] + matrix[0][j-1];
                }
                else if (j==0 && i>0){
                    matrix[i][0] = matrix[i][0] + matrix[i-1][0];
                }
                else {
                    matrix[i][j] = Math.min(matrix[i-1][j], matrix[i][j-1]) + matrix[i][j];
                }
            }
        }

        //the result should be the right bottom node
        return matrix[row-1][col-1];
    }

}
