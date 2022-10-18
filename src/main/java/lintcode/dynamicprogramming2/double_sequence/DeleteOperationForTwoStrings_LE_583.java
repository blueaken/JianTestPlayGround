package lintcode.dynamicprogramming2.double_sequence;

public class DeleteOperationForTwoStrings_LE_583 {
    /*
        2 solutions:
        A - similar to EditDistance, Bottom Up DP -
        if (s.charAt(i) == t.charAt(j)) {
            dp[i][j] = dp[i-1][j-1]
        } else {
            dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + 1
        }

        B- the result of delete operations is actually the LCS, so the result is:
        s.length() - LCS + t.length() - LCS
    */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];

        //init
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        //dp
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
