package ninechapter_algorithm.chapter5_dynamic_prgramming_2.optional.ksum.second;

/**
 * Author: blueaken
 * Date: 5/25/16 10:06
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
            return Integer.MIN_VALUE;
        }

        int len = A.length;
        int[][][] T = new int[len + 1][k + 1][target + 1];

        //init
        for (int i = 0; i < len; i++) {
            T[i][0][0] = 1;
        }

        //dp
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= k; j++) {
                for (int t = 1; t <= target; t++) {
                    T[i][j][t] = T[i - 1][j][t];
                    if (t >= A[i - 1]) {
                        T[i][j][t] += T[i -1][j - 1][t - A[i - 1]];
                    }
                }
            }
        }
        return T[len][k][target];
    }
}
