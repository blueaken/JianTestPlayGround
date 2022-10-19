package lintcode.dynamicprogramming2.interval2;

public class MinInsertionStepsToMakeStringPalindrome_LE_1312 {
    /*
        ref labaladong post and Huifeng Guan wiki
        - similar to 516 Longest Palindrome SubSequence
        - another way to do it is: string s length - longestPalindromeSubseq(s);
    */
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        //init val to 0, skip

        //dp
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1]) + 1;
                }
            }
        }

        return dp[0][n-1];
    }
}
