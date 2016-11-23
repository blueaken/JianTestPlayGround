package ninechapter_algorithm.chapter5_dynamic_prgramming_2.longestcommonsubstring;

/**
 * Author: blueaken
 * Date: 4/7/16 9:55 AM
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
        //https://www.youtube.com/watch?v=BysNXJHzCEs
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i-1) == B.charAt(j-1)) {
                    res[i][j] = res[i-1][j-1] + 1;
                } else {
                    res[i][j] = 0;
                }
                max = Math.max(res[i][j], max);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String A = "abcdaf";
        String B = "ebcdf";
        System.out.println(longestCommonSubstring(A, B));
    }
}
