package lintcode.string.rollinghash;

public class StrStr_LE_28_BruteForce_P1 {
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
        3.18.2023
        - try brute force
    */
    public int strStr(String haystack, String needle) {
        int N = haystack.length(), L = needle.length();
        for (int i = 0; i + L <= N; i++) {
            String sub = haystack.substring(i, i+L);
            if (sub.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
