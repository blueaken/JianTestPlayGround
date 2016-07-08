package ninechapter_algorithm.chapter5_dynamic_prgramming_2.longestcommonsubsequence.second;

/**
 * Author: blueaken
 * Date: 7/7/16 23:12
 */
public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if (A == null || B == null) {
            return 0;
        }

        //init
        int m = A.length();
        int n = B.length();
        int[][] res = new int[m + 1][n + 1];

        //dp
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    res[i][j] = res[i - 1][j - 1] + 1;
                } else {
                    res[i][j] = Math.max(res[i - 1][j], res[i][j - 1]);
                }
            }
        }
        return res[m][n];
    }
}
