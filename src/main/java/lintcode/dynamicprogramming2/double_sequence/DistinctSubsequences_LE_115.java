package lintcode.dynamicprogramming2.double_sequence;

public class DistinctSubsequences_LE_115 {
    /*
        10.17.2022
        - read labuladong post
        - his post use TopDown with mem[], but the Bottom Up solution is easier to understand
        - Bottom up DP
    */
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (m < n) {
            return 0;
        }

        int[][] dp = new int[m+1][n+1];

        //init
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = 0;
        }

        //dp
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
}
