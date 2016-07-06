package ninechapter_algorithm.chapter5_dynamic_prgramming_2.distinctsubsequence.second;

/**
 * Author: blueaken
 * Date: 7/6/16 12:06
 */
public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        if (T == null || T.length() == 0) {
            return 1;
        }
        if (S == null || S.length() == 0) {
            return 0;
        }

        //init
        int m = S.length();
        int n = T.length();
        int[][] res = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            res[i][0] = 1;
        }

        //dp - state: res[i][j] 表示S的前i个字符中选取T的前j个字符，有多少种方案
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    res[i][j] = res[i - 1][j] + res[i - 1][j - 1];
                } else {
                    res[i][j] = res[i - 1][j];
                }
            }
        }
        return res[m][n];
    }
}
