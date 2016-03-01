package ninechapter.chapter4_dynamic_prgramming_1.triangle;

/**
 * Author: blueaken
 * Date: 3/1/16 2:39 PM
 */
public class Solution_Traverse {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public static int minimumTotal(int[][] triangle) {
        int[] ret = new int[1];
        ret[0] = Integer.MAX_VALUE;
        int n = triangle.length;

        rec(triangle, 0, 0, 0, n, ret);
        return ret[0];
    }

    private static void rec(int[][] A, int x, int y, int sum, int n, int[] ret) {
        if (x == n) {
            if (sum < ret[0]) {
                ret[0] = sum;
            }
            return;
        }

        rec(A, x+1, y, sum + A[x][y], n, ret);
        rec(A, x+1, y+1, sum + A[x][y], n, ret);
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
