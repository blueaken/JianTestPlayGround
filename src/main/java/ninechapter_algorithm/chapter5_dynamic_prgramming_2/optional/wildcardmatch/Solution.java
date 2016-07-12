package ninechapter_algorithm.chapter5_dynamic_prgramming_2.optional.wildcardmatch;

/**
 * Author: blueaken
 * Date: 7/11/16 18:22
 */
public class Solution {
    /**
     * @param s: A string
     * @param p: A string includes "?" and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        if (s == null || p == null) {
            return false;
        }

        //init
        int m = s.length();
        int n = p.length();
        boolean[][] res = new boolean[m + 1][n + 1];
        res[0][0] = true;
        for (int i = 1; i <= n; i++) {
            res[0][i] = res[0][i - 1] && p.charAt(i - 1) == '*';
        }

        //dp
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char curP = p.charAt(j - 1);
                if (s.charAt(i - 1) == curP || curP == '?') {
                    res[i][j] = res[i - 1][j - 1];
                } else if (curP == '*') {
                    res[i][j] = res[i - 1][j] || res[i][j - 1];
                } else {
                    res[i][j] = false;
                }
            }
        }
        return res[m][n];
    }
}
