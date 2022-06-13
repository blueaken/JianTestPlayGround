package lintcode.dynamicprogramming2;

public class LongestPalindromeSubString_200_P1 {
    //TLE - Time - O(N^2)
    public String longestPalindrome(String s) {
        //dp
        int[][] res = new int[s.length()][s.length()];
        //init length = 1 entries
        for (int i = 0; i < s.length(); i++) {
            res[i][i] = 1;
        }

        String result = s.substring(0, 1); //init result to 1st char
        for (int len = 2; len <= s.length(); len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                int j = i + len - 1;
                String curSubStr = s.substring(i, j + 1);

                //special case for length = 2
                if (len == 2 && s.charAt(i) == s.charAt(j)) {
                    res[i][j] = 2;
                    if (len > result.length()) {
                        result = curSubStr;
                    }
                    continue;
                }
                if (s.charAt(i) == s.charAt(j) && res[i+1][j-1] > 0) {
                    res[i][j] = 2 + res[i+1][j-1];
                    if (len > result.length()) {
                        result = curSubStr;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        String input = "aabbccc";//ccc
//        String input = "aabbc";//aa
        String input = "aa";//aa

        LongestPalindromeSubString_200_P1 solution = new LongestPalindromeSubString_200_P1();
        System.out.println(solution.longestPalindrome(input));
    }
}
