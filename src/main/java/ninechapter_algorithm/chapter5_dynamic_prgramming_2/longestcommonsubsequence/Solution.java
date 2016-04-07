package ninechapter_algorithm.chapter5_dynamic_prgramming_2.longestcommonsubsequence;

/**
 * Author: blueaken
 * Date: 4/7/16 9:47 AM
 */
public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public static int longestCommonSubstring(String A, String B) {
        // write your code here
        if (A == null || A.length() == 0
                || B == null || B.length() == 0) {
            return 0;
        }

        //init
        int n = A.length();
        int m = B.length();
        int[][] res = new int[n+1][m+1];
        for (int i = 0; i < n; i++) {
            res[i][0] = 0;
        }
        for (int i = 1; i < m; i++) {
            res[0][i] = 0;
        }

        //dp
        //ref: https://www.youtube.com/watch?v=NnD96abizww
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i-1) == B.charAt(j-1)) {
                    res[i][j] = res[i-1][j-1] + 1;
                } else {
                    res[i][j] = Math.max(res[i][j-1], res[i-1][j]);
                }
            }
        }

        return res[n][m];
    }

    public static void main(String[] args) {
        String A = "abcdaf";
        String B = "acbcf";
        System.out.println(longestCommonSubstring(A, B));
    }
}
