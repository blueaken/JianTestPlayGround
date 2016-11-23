package ninechapter_algorithm.chapter5_dynamic_prgramming_2.longestcommonsubstring.second;

/**
 * Author: blueaken
 * Date: 7/7/16 23:02
 */
public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        if (A == null || B == null) {
            return 0;
        }

        //init
        int m = A.length();
        int n = B.length();
        int[][] res = new int[m + 1][n + 1];

        //dp
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    res[i][j] = res[i - 1][j - 1] + 1;
                    max = Math.max(res[i][j], max);
                } else {
                    res[i][j] = 0;
                }
            }
        }
        return max;
    }
}
