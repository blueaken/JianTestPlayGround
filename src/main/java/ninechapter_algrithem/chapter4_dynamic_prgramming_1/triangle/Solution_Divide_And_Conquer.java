package ninechapter_algrithem.chapter4_dynamic_prgramming_1.triangle;

/**
 * Author: blueaken
 * Date: 3/1/16 2:50 PM
 */
public class Solution_Divide_And_Conquer {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public static int minimumTotal(int[][] triangle) {
        int n = triangle.length;

        return rec(triangle, 0, 0, n);
    }

    private static int rec(int[][] A, int x, int y, int n) {
        if (x == n) {
            return 0;
        }

        return A[x][y] + Math.min(rec(A, x+1, y, n), rec(A, x+1, y+1, n));
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
