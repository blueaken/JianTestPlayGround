package lintcode.string;

public class StrStr_LE_028_KMP_DP {
    /*
        10.26.2022
        ref labaladong post
        - 1st retry with brute force, Time - O(MN)
        - next try the KMP with DP way - O(M+N)
    */
    int[][] dp;
    public int strStr(String haystack, String needle) {
        int n = needle.length();
        dp = new int[n][256]; //dp[pattern cur char index (state)][text char] = next pattern char index
        calcKMP(needle);

        return search(haystack);
    }

    private void calcKMP(String needle) {
        //base case
        dp[0][needle.charAt(0)] = 1;

        int X = 0; //shadow pos start from 0

        //dp
        int n = dp.length;
        for (int i = 1; i < n; i++) {
            for (int c = 0; c < 256; c++) {
                if (needle.charAt(i) == c) {
                    dp[i][c] = i + 1;
                } else {
                    dp[i][c] = dp[X][c];
                }
            }
            X = dp[X][needle.charAt(i)];
        }
    }

    private int search(String haystack) {
        int m = haystack.length();
        int n = dp.length;

        int j = 0;
        for (int i = 0; i < m; i++) {
            j = dp[j][haystack.charAt(i)];
            if (j == n) {
                return i-n+1;
            }
        }
        return -1;
    }
}
