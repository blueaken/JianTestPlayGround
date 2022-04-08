package lintcode.dynamicprogramming;

public class MinPathSum_110_REC {
    private static int result = Integer.MAX_VALUE;
    /**
     * @param grid: a list of lists of integers
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    //ref - https://segmentfault.com/a/1190000040903243/en
    public int minPathSum(int[][] grid) {
        // write your code here
        rec (grid, 0, 0, 0);
        return result;
    }
    private void rec (int[][] grid, int x, int y, int sum) {
        sum += grid[x][y];
        // 走到右下角的单元格
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            result = Math.min(sum, result);
            return;
        }
        if (x == grid.length - 1) {
            // 走到最后一行，往右走
            rec(grid, x, y + 1, sum);
        } else if (y == grid[0].length - 1) {
            // 走到最后一列，往下走
            rec(grid, x + 1, y, sum);
        } else {
            // 往下走
            rec(grid, x, y + 1, sum);
            // 往右走
            rec(grid, x + 1, y, sum);
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

        MinPathSum_110_REC solution = new MinPathSum_110_REC();
        System.out.println(solution.minPathSum(grid));
    }
}
