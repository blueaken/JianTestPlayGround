package lintcode.binarysearch.labuladong;

public class IsSubsequence_LE_392 {
    /**
     1.28.2023
     ref 东哥 post, there is a straightward O(N) solution
     */
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
