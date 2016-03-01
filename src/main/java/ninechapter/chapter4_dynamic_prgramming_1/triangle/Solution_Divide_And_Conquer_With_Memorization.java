package ninechapter.chapter4_dynamic_prgramming_1.triangle;

/**
 * Author: blueaken
 * Date: 3/1/16 3:21 PM
 */
public class Solution_Divide_And_Conquer_With_Memorization {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public static int minimumTotal(int[][] triangle) {
        int n = triangle.length;

        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                ans[i][j] = Integer.MAX_VALUE;
            }
        }

        return rec(triangle, 0, 0, n, ans);
    }

    private static int rec(int[][] A, int x, int y, int n, int[][] ans) {
        if (x == n) {
            return 0;
        }

        if (ans[x][y] != Integer.MAX_VALUE) {
            return ans[x][y];
        }

        ans[x][y] = A[x][y] + Math.min(rec(A, x+1, y, n, ans), rec(A, x+1, y+1, n, ans));
        return ans[x][y];
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3}
        };

        System.out.println(minimumTotal(input));
    }
}
