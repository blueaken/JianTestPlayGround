package leetcode.algorithm.dp.longestpalindromicsubstring;

/**
 * Author: blueaken
 * Date: 1/27/16 9:55 AM
 */
public class Solution {
    public static String longestPalindrome(String s) {
        if (s==null || s.length()==0) return null;

        int n = s.length();
        int maxLen = 0;
        int startIndex = 0;

        //init of len 2 needed?
        //yes, in case of "acbbc" type;
        boolean[][] dp = new boolean[1000][1000];
        for (int i=0; i<n; i++){
            dp[i][i] = true;
        }
        for (int i=0; i<n-1; i++){
            if (s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                maxLen = 2;
                startIndex = i;
            }
        }

        for (int len=3; len<=n; len++){
            for (int i=0; i<n-len+1; i++){
                int j = i+len-1;
                if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    maxLen = len;
                    startIndex = i;
                }
            }
        }

        //treat the trivial case of only one char as not found
        return maxLen>1 ? s.substring(startIndex, startIndex+maxLen) : null;
    }

    public static void main(String[] args) {
//        String input = "caba";
        String input = "cabacdfgdcaba";

        System.out.println("the longest palindrome is: " + longestPalindrome(input));
    }
}
