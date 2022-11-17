package lintcode.dynamicprogramming2;

public class LongestPalindromeSubString_200_P2 {
    /*
        - retry since DP got TLE
        - for each position try to find the longest palindrome, and record the longest positions
        - Time also O(N^2)
    */
    public String longestPalindrome(String s) {
        int[] maxLen = new int[2]; //0 - maxLen start pos, 1 - maxLen end pos

        for (int i = 0; i < s.length(); i++) {
            extend(s, i, i, maxLen); //if palendrome len is odd
            extend(s, i, i + 1, maxLen); //if palendrome len is even
        }
        return s.substring(maxLen[0], maxLen[1] + 1);
    }

    private void extend(String s, int left, int right, int[] maxLen) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        left++; right--; //back to last valid positions

        int curLen = right - left + 1;
        if (curLen > maxLen[1] - maxLen[0] + 1) {
            maxLen[0] = left;
            maxLen[1] = right;
        }
    }

    public static void main(String[] args) {
        String input = "aabbccc";//ccc
//        String input = "aabbc";//aa
//        String input = "aa";//aa

        LongestPalindromeSubString_200_P2 solution = new LongestPalindromeSubString_200_P2();
        System.out.println(solution.longestPalindrome(input));
    }
}
