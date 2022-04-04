package lintcode.dynamicprogramming2;

public class LongestPalindromeSubString_200 {
    /**
     * @param s: input string
     * @return: a string as the longest palindromic substring
     */
    //Idea: inspired by Tushor's Longest Palindromic Subsequence & WordBreak Video
    //      && its code - https://github.com/mission-peace/interview/blob/master/src/com/interview/string/LongestPalindromeSubstring.java
    //Note: Tushor's video on Longest Palindromic Substring is about Manacher's Algorithm (O(N)), skip this time.
    public String longestPalindrome(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return s;
        }

        //init
        int[][] res = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            res[i][i] = 1;
        }

        //dp
        String result = s.substring(0,1);
        for (int len = 2; len <= s.length(); len++) {
            for (int start = 0; start < s.length() - len + 1; start ++) {
                int end = start + len - 1;
                //handle special case when len == 2
                if (len == 2 && s.charAt(start) == s.charAt(end)) {
                    res[start][end] = 2;
                    if (end - start + 1 > result.length()) {
                        result = s.substring(start, end + 1);
                    }
                }
                if (s.charAt(start) == s.charAt(end) && res[start+1][end-1] > 0) {
                    res[start][end] = 2 + res[start+1][end-1];
                    if (end - start + 1 > result.length()) {
                        result = s.substring(start, end + 1);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        String input = "aabbccc";
        String input = "aabbc";

        LongestPalindromeSubString_200 solution = new LongestPalindromeSubString_200();
        System.out.println(solution.longestPalindrome(input));
    }
}
