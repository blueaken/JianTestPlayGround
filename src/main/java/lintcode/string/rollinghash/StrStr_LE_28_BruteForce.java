package lintcode.string.rollinghash;

public class StrStr_LE_28_BruteForce {
    /*
        10.26.2022
        ref labaladong post
        - 1st retry with brute force, Time - O(MN)
        - next try the KMP with DP way - O(M+N)
        ====================
        12.07.2022
        ref 东哥 帖子
        - 先再试一下brute force
        - 然后用Rabin Karp算法, 基本是一个rolling hash的idea
        ====================
    */
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        for (int i = 0; i <= m-n; i++) {
            String cur = haystack.substring(i, i+n);
            if (cur.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
