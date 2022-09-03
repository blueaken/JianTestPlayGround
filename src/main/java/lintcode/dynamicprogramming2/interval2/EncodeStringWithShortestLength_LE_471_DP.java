package lintcode.dynamicprogramming2.interval2;

public class EncodeStringWithShortestLength_LE_471_DP {
    /*
        ref https://leetcode.com/problems/encode-string-with-shortest-length/discuss/2308429/Java-top-down-and-bottom-up-with-detailed-comments
        - a smart solution:
        1. If a String length is less than or equal to 4 it can't be shortened via encoding
        2. Else if a string is composed of repeating substrings then we find the repeating substring, encode the string using the substring and return because this is the shortest encoding of the string.
        3. Else, we'll need to split the string, encode the left and right and concatenate. The pivot for the split lies in the range [1, s.length]. We return the encoding having minimum length
        4. By using memoization we can speed up the above exponential algorithm to o(n^3). We can memoize because left and right strings above will repeat across recrusion calls.

    =============================================================
    Retry with bottom up DP, which is more efficient since we build the encoding of short substrings first and store it in cache, then long substring can be build from the cache result, which the cache (dp array) can be used more efficiently.
    ===============================================================
    */

    String[][] dp;
    public String encode(String s) {
        int n = s.length();
        //dp[i][j] is the minimum length string from index i to j, both inclusive
        dp = new String[n][n];

        //init
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dp[i][j] = s.substring(i, i+1);
                } else {
                    dp[i][j] = "";
                }
            }
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                String cur = s.substring(i, j+1);

                dp[i][j] = cur;
                if (cur.length() <= 4) {
                    continue;
                }

                String encoding = encodingStr(cur, i);
                if (encoding.length() < cur.length()) {
                    dp[i][j] = encoding;
                    continue;
                }

                // Otherwise we split string at different positions and get the encoding by concatinating left and right substrings. We store the minimum of the all the above encodings
                for (int k = i; k < j; k++) {
                    // Note that each left and right is a valid substring of the input string that is shorter than the substring we're trying to process now. So we'll already have it in the dp array and just have to get it from there
                    String l = dp[i][k];
                    String r = dp[k+1][j];
                    if (l.length() + r.length() < dp[i][j].length()) {
                        dp[i][j] = l+r;
                    }
                }

            }
        }

        return dp[0][n-1];
    }

    private String encodingStr(String s, int left){
        int idx = (s+s).indexOf(s, 1);
        String encoding = idx < s.length() ? String.format("%d[%s]",  s.length()/idx, dp[left][left+idx-1]) : s;
        return encoding;
    }

    public static void main(String[] args) {
        EncodeStringWithShortestLength_LE_471_DP solution = new EncodeStringWithShortestLength_LE_471_DP();
        String s = "dabcabcabc"; //"d3[abc]"
//        String s = "aaaaa"; //"5[a]"
        System.out.println(solution.encode(s));
    }

}
