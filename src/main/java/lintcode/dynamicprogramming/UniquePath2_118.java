package lintcode.dynamicprogramming;

public class UniquePath2_118 {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    //Note: 也可以用 dfs递归 + 记忆化搜索优化查询效率解
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if (obstacleGrid == null || obstacleGrid[0] == null) {
            return 0;
        }

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int res[][] = new int[row][col];

        //init && dp
        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            res[i][0] = 1;
        }
        for (int i = 0; i < col; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            res[0][i] = 1;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                res[i][j] = res[i-1][j] + res[i][j-1];
            }
        }
        return res[row-1][col-1];
    }

    public static void main(String[] args) {
        int[][] input = {{1,0},{0,0},{0,0},{0,0},{0,0}};

        UniquePath2_118 solution = new UniquePath2_118();
        System.out.println(solution.uniquePathsWithObstacles(input));
    }
}
