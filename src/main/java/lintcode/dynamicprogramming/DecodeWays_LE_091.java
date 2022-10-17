package lintcode.dynamicprogramming;

public class DecodeWays_LE_091 {
    /*
        10.17.2022
        - ref labuladong post
        - BottomUp DP
        - note base case for dp[0] = 1
    */
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1]; //dp[i] - the number of Decoding to string s ending in position i-1

        //init
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        //dp
        for (int i = 2; i <= n; i++) {
            int preOneDigit = s.charAt(i-1) - '0';
            if (preOneDigit != 0) {
                dp[i] += dp[i-1];
            }

            int preTwoDigit = (s.charAt(i-2) - '0') * 10 + (s.charAt(i-1) - '0');
            if (preTwoDigit >= 10 && preTwoDigit <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
