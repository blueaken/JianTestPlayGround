package ninechapter_algorithm.chapter5_dynamic_prgramming_2.optional.ksum;

/**
 * Author: blueaken
 * Date: 4/9/16 10:54 PM
 */
public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public static int kSum(int A[], int k, int target) {
        // write your code here

        //init
        int n = A.length;
        int[][][] res = new int[n+1][k+1][target+1];
        for (int i = 0; i <= n; i++) {
            res[i][0][0] = 1;   //select 0 number from i to the target: 0
        }

        //dp
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                for (int m = 1; m <= target; m++) {
                    res[i][j][m] = res[i-1][j][m];
                    if (m - A[i-1] >= 0) {
                        res[i][j][m] += res[i-1][j-1][m - A[i-1]];
                    }
                }
            }
        }

        return res[n][k][target];
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4};
        int k = 2;
        int target = 5;

        System.out.println(kSum(A, k, target));
    }
}
