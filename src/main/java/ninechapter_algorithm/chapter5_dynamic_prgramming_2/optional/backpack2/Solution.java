package ninechapter_algorithm.chapter5_dynamic_prgramming_2.optional.backpack2;

/**
 * Author: blueaken
 * Date: 4/9/16 10:59 AM
 */
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        if (A == null || A.length == 0
                || V == null || V.length == 0
                || A.length != V.length
                || m == 0) {
            return 0;
        }

        //init
        int n = A.length;
        int[][] res = new int[n][m+1];
        for (int i = 0; i < n; i++) {
            res[i][0] = 0;
        }
        for (int i = 1; i <= m; i++) {
            res[0][i] = i >= A[0] ? V[0] : 0;
        }

        //dp
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j < A[i]) {
                    res[i][j] = res[i-1][j];
                } else {
                    res[i][j] = Math.max(res[i-1][j], V[i] + res[i-1][j-A[i]]);
                }
            }
        }
        return res[n-1][m];
    }
}
