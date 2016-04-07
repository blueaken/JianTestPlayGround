package ninechapter_algorithm.chapter5_dynamic_prgramming_2.distinctsubsequence;

/**
 * Author: blueaken
 * Date: 4/7/16 3:27 PM
 */
public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        if (S == null || S.length() == 0) {
            return 0;
        }
        if (T == null || T.length() == 0) {
            return 1;
        }

        //init
        int n = S.length();
        int m = T.length();
        int res[][] = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            res[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            res[0][i] = 0;
        }

        //dp
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (S.charAt(i-1) == T.charAt(j-1)) {
                    res[i][j] = res[i-1][j-1] + res[i-1][j];
                } else {
                    res[i][j] = res[i-1][j];
                }
            }
        }

        return res[n][m];
    }
}
