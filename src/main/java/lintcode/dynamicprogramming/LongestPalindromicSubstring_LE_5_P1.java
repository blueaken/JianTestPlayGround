package lintcode.dynamicprogramming;

public class LongestPalindromicSubstring_LE_5_P1 {
    /*
        - retry since DP got TLE
        - for each postion try to find the longest palindrome, and record the longest positions
        - Time also O(N^2)
        ==============================
        - retry with labaladong post
        - 双指针方法
        ==============================
        P1 10.29.2022
        ==============================
    */
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";
        for (int i = 0; i < n; i++) {
            String s1 = getPalindrome(s, i, i);
            String s2 = getPalindrome(s, i, i+1);

            res = s1.length() > res.length() ? s1 : res;
            res = s2.length() > res.length() ? s2 : res;
        }
        return res;
    }

    String getPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--; r++;
        }
        l++; r--;

        //note Java String substring() returns Empty String if begin index equals end index
        return s.substring(l, r+1);
    }
}
