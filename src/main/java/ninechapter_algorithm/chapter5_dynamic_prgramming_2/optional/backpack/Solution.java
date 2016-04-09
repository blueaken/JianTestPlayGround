package ninechapter_algorithm.chapter5_dynamic_prgramming_2.optional.backpack;

import java.util.Arrays;

/**
 * Author: blueaken
 * Date: 4/8/16 6:25 PM
 */
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public static int backPack(int m, int[] A) {
        // write your code here
        if (m == 0 || A == null || A.length == 0) {
            return 0;
        }

        //init
        int n = A.length;
        int[][] res = new int[n][m+1];
        for (int i = 0; i < n; i++) {
            res[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            res[0][i] = i >= A[0] ? A[0] : 0;
        }

        //dp
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j < A[i]) {
                    res[i][j] = res[i-1][j];
                } else {
                    res[i][j] = Math.max(res[i-1][j], A[i] + res[i-1][j-A[i]]);
                }
            }
        }

        return res[n-1][m];
    }

    public static void main(String[] args) {
        int m = 10;
        int[] A = {3,4,8,5};

        System.out.println(backPack(m, A));
    }
}
