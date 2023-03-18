package lintcode.string.rollinghash;

public class StrStr_LE_28_RabinKarp_P1 {
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
        - try Rabin Karp算法, 基本是一个rolling hash + 滑动窗口 + Hash冲突处理
    */
    public int strStr(String haystack, String needle) {
        int N = haystack.length(), L = needle.length();
        int R = 256;
        long mod = (long)1e9 + 7;

        long RL = 1;
        for (int i = 0; i < L-1; i++) {
            RL = RL * R % mod;
        }

        long targetHash = 0;
        for (int i = 0; i < L; i++) {
            targetHash = (targetHash * R % mod + needle.charAt(i)) % mod;
        }

        int left = 0, right = 0;
        long windowHash = 0;
        while (right < N) {
            windowHash = (windowHash * R % mod + haystack.charAt(right)) % mod;
            right++;

            while (right - left == L) {
                if (windowHash == targetHash) {
                    // 防止Hash冲突，再判断一次
                    String cur = haystack.substring(left, right);
                    if (cur.equals(needle)) {
                        return left;
                    }
                }

                windowHash = (windowHash - haystack.charAt(left) * RL % mod + mod) % mod;
                left++;
            }
        }
        return -1;
    }
}
