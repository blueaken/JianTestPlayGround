package ninechapter_algorithm.chapter5_dynamic_prgramming_2.optional.ksum.third;

/**
 * Author: blueaken
 * Date: 7/9/16 13:55
 */
public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public int kSum(int A[], int k, int target) {
        // write your code here
        if (A == null || A.length < k) {
            return 0;
        }

        //init
        int len = A.length;
        int[][][] res = new int[len + 1][k + 1][target + 1];
        for (int i = 0; i <= len; i++) {
            res[i][0][0] = 1;
        }

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= k; j++) {
                for (int t = 1; t <= target; t++) {
                    res[i][j][t] = res[i - 1][j][t];
                    if (t - A[i - 1] >= 0) {
                        res[i][j][t] += res[i - 1][j - 1][t - A[i - 1]];
                    }
                }
            }
        }
        return res[len][k][target];
    }
}
