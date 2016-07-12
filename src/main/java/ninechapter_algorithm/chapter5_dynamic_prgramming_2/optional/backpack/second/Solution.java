package ninechapter_algorithm.chapter5_dynamic_prgramming_2.optional.backpack.second;

/**
 * Author: blueaken
 * Date: 7/11/16 17:02
 */
public class Solution {
    public int backPack(int m, int[] A) {
        // write your code here
        if (A == null || A.length == 0 || m < 0) {
            return 0;
        }

        //init
        int len = A.length;
        int[][] res = new int[len][m + 1];
        for (int i = 0; i < len; i++) {
            res[i][0] = 0;
        }
        for (int i = 1; i <= m; i++) {
            res[0][i] = A[0] <= i ? A[0] : 0;
        }

        //dp
        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= m; j++) {
                if (A[i] <= j) {
                    res[i][j] = Math.max(res[i - 1][j], A[i] + res[i - 1][j - A[i]]);
                } else {
                    res[i][j] = res[i - 1][j];
                }
            }
        }
        return res[len - 1][m];
    }
}
