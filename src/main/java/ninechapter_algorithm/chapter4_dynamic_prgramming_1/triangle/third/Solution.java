package ninechapter_algorithm.chapter4_dynamic_prgramming_1.triangle.third;

/**
 * Author: blueaken
 * Date: 7/2/16 10:04
 */
public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if (triangle == null || triangle[0] == null) {
            return 0;
        }
        int n = triangle.length;
        int[][] path = new int[n][n];

        //init
        path[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            path[i][0] = triangle[i][0] + path[i - 1][0];
            path[i][i] = triangle[i][i] + path[i - 1][i - 1];
        }

        //dp
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                path[i][j] = triangle[i][j] + Math.min(path[i - 1][j], path[i - 1][j - 1]);
            }
        }

        //find min on last level
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(path[n - 1][i], min);
        }
        return min;
    }
}
