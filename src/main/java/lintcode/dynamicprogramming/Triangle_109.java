package lintcode.dynamicprogramming;

public class Triangle_109 {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if (triangle == null || triangle[0] == null) {
            return 0;
        }

        int row = triangle.length;
        int col = triangle[row-1].length;
        int res[][] = new int[row][col];

        //init
        res[0][0] = triangle[0][0];
        for (int i = 1; i < row; i++) {
            res[i][0] = res[i-1][0] + triangle[i][0];
            res[i][i] = res[i-1][i-1] + triangle[i][i];
        }

        //dp
        for (int i = 2; i < row; i++) {
            for (int j = 1; j < i; j++) {
                res[i][j] = Math.min(res[i-1][j], res[i-1][j-1]) + triangle[i][j];
            }
        }

        int minTotal = Integer.MAX_VALUE;
        for (int i = 0; i < col; i++) {
            minTotal = Math.min(minTotal, res[row-1][i]);
        }

        return minTotal;
    }

    public static void main(String[] args) {
        int[][] input = {{1},{3,4},{6,5,7},{4,1,8,3}};

        Triangle_109 solution = new Triangle_109();
        System.out.println(solution.minimumTotal(input));
    }
}
