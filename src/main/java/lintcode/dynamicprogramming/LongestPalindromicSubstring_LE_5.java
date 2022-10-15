package lintcode.dynamicprogramming;

public class LongestPalindromicSubstring_LE_5 {
    /*
        - retry since DP got TLE
        - for each postion try to find the longest palindrome, and record the longest positions
        - Time also O(N^2)
        ==============================
        - retry with labaladong post
        - 双指针方法
    */
    public String longestPalindrome(String s) {
        String res =  "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i+1);

            res = res.length() < s1.length() ? s1 : res;
            res = res.length() < s2.length() ? s2 : res;
        }
        return res;
    }

    private String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length()
                && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        l++;r--;//找回前面位置

        //note Java String substring() returns Empty String if begin index equals end index
        return s.substring(l, r+1);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring_LE_5 solution = new LongestPalindromicSubstring_LE_5();
        String s = "cbbd";
//        System.out.println(solution.longestPalindrome(s));
        System.out.println(s.substring(2,2));
        System.out.println(s.substring(2,3));

        System.out.println(s.substring(2,1));
    }
}
