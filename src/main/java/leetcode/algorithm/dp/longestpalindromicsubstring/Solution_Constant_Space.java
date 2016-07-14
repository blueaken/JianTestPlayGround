package leetcode.algorithm.dp.longestpalindromicsubstring;

/**
 * Author: blueaken
 * Date: 1/27/16 11:09 AM
 */
public class Solution_Constant_Space {
    public static String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i=0; i<s.length(); i++){
            int len1 = expandFromCenter(s, i, i);
            int len2 = expandFromCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            if (len > end - start){
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }

        return s.substring(start, end+1);
    }

    private static int expandFromCenter(String ori, int left, int right){
        while (left >= 0 && right < ori.length() && ori.charAt(left) == ori.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
//        String input = "caba";
        String input = "cabacdfgdcaba";

        System.out.println("the longest palindrome is: " + longestPalindrome(input));
    }
}
