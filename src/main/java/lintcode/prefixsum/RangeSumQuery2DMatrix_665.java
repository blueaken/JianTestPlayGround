package lintcode.prefixsum;

public class RangeSumQuery2DMatrix_665 {
    private int[][] matrix;

    public RangeSumQuery2DMatrix_665(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        //prefix sum
        int sum[][] = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i <sum.length; i++) {
            for (int j = 1; j < sum[0].length; j++) {
                sum[i][j] = matrix[i-1][j-1] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
            }
        }

        return sum[row2+1][col2+1] - sum[row1][col2+1] - sum[row2+1][col1] + sum[row1][col1];
    }

    public static void main(String[] args) {
        int[][] input = {{2,0,-3,4},{6,3,2,-1},{5,4,7,3},{2,-6,8,1}};//expect a prefix sum matrix with value of 37 at lower right corner

        RangeSumQuery2DMatrix_665 solution = new RangeSumQuery2DMatrix_665(input);
        System.out.println(solution.sumRegion(1,1,3,2));//expect 18
    }
}
