package lintcode.string;

public class StrStr_LE_28_BruteForce {
    /*
        10.26.2022
        ref labaladong post
        - 1st retry with brute force, Time - O(MN)
    */
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        for (int i = 0; i <= m - n; i++) {
            int j;
            for (j = 0; j < n; j++) {
                if (needle.charAt(j) != haystack.charAt(i+j)) {
                    break;
                }
            }
            if (j == n) {
                return i;
            }
        }
        return -1;
    }
}
