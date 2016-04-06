package ninechapter_algorithm.chapter4_dynamic_prgramming_1.triangle.second;

/**
 * Author: blueaken
 * Date: 4/6/16 11:04 AM
 */
public class Solution_TopDown {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public static int minimumTotal(int[][] triangle) {
        // write your code here
        if (triangle == null || triangle.length == 0 || triangle[0].length == 0){
            return 0;
        }

        //init
        int n = triangle.length;
        int[][] res = new int[n][n];
        res[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            res[i][0] = triangle[i][0] + res[i-1][0];
            res[i][i] = triangle[i][i] + res[i-1][i-1];
        }

        //dp
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                res[i][j] = triangle[i][j] + Math.min(res[i-1][j-1], res[i-1][j]);
            }
        }

        //find the min
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(res[n-1][i], min);
        }
        return min;
    }

    public static void main(String[] args) {
//        int[][] input = new int[][]{
//                {2},
//                {3, 4},
//                {6, 5, 7},
//                {4, 1, 8, 3}
//        };

        int[][] input = new int[][]{
                        {-7},
                        {-2,1},
                        {-5,-5,9},
                        {-4,-5,4,4},
                        {-6,-6,2,-1,-5},
                        {3,7,8,-3,7,-9},
                        {-9,-1,-9,6,9,0,7},
                        {-7,0,-6,-8,7,1,-4,9},
                        {-3,2,-6,-9,-7,-6,-9,4,0},
                        {-8,-6,-3,-9,-2,-6,7,-5,0,7},
                        {-9,-1,-2,4,-2,4,4,-1,2,-5,5},
                        {1,1,-6,1,-2,-4,4,-2,6,-6,0,6},
                        {-3,-3,-6,-2,-6,-2,7,-9,-5,-7,-5,5,1}
        };

        System.out.println(minimumTotal(input));
    }
}
