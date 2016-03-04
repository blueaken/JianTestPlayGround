package leetcode.dp.longestpalindromicsubstring.second;

/**
 * Author: blueaken
 * Date: 3/4/16 2:10 PM
 */
public class Solution {
    public static String longestPalindrome(String s) {
        if (s==null || s.length()==0) {
            return null;
        }

        String result = s.substring(0,1);
        boolean[][] isPanli = new boolean[s.length()][s.length()];

        //init  and dp together
        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j-i < 2 || isPanli[i+1][j-1])) {
                    isPanli[i][j] = true;
                    if (j-i+1 > result.length()) {
                        result = s.substring(i, j+1);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        String input = "caba";
        String input = "cabacdfgdcaba";

        System.out.println("the longest palindrome is: " + longestPalindrome(input));
    }
}
