package lintcode.string.rollinghash;

public class StrStr_LE_28_RabinKarp {
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
        // Rabin-Karp 指纹字符串查找算法
        int m = haystack.length();
        int n = needle.length();
        long mod = (long)1e9 + 7;

        int R = 256;
        long RL = 1; //RL is R^(n-1)
        for (int i = 0; i < n-1; i++) {
            RL = RL * R % mod;
        }

        //calc needle's hash value
        long targetHash = 0;
        for (int i = 0; i < n; i++) {
            targetHash = (R * targetHash % mod + needle.charAt(i)) % mod;
        }

        long windowHash = 0;
        int left = 0, right = 0;
        while (right < m) {
            //add new char into low position
            windowHash = (R * windowHash % mod + haystack.charAt(right)) % mod;
            right++;

            while (right - left == n) {
                if (windowHash == targetHash) {
                    // 当前窗口中的子串哈希值等于模式串的哈希值
                    // 还需进一步确认窗口子串是否真的和模式串相同，避免哈希冲突
                    if (needle.equals(haystack.substring(left, right))) {
                        return left;
                    }
                }
                //remove leftmost char from high position
                windowHash = (windowHash - haystack.charAt(left) * RL % mod + mod) % mod;
                left++;
            }
        }
        return -1;
    }
}
