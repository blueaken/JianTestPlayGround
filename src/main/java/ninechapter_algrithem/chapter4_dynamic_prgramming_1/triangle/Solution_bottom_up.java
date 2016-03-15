package ninechapter_algrithem.chapter4_dynamic_prgramming_1.triangle;

/**
 * Author: blueaken
 * Date: 3/1/16 11:17 AM
 */
public class Solution_bottom_up {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public static int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return -1;
        }
        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }

        //assume triangle.length == triangle[0].length. can verify with interviewer
        int n = triangle.length;
        int[][] f = new int[n][n];

        //init bottom value
        for (int i = 0; i < n; i++) {
            f[n-1][i] = triangle[n-1][i];
        }

        //bottom up
        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                f[i][j] = triangle[i][j] + Math.min(f[i+1][j], f[i+1][j+1]);
            }
        }

        return f[0][0];
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
