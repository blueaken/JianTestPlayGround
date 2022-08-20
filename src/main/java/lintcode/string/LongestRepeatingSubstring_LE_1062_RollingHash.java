package lintcode.string;

import java.util.HashSet;
import java.util.Set;

public class LongestRepeatingSubstring_LE_1062_RollingHash {
    /*
        ref https://www.youtube.com/watch?v=ONT_PrPdMuQ
        - exactly same as 1044, but the diff is s.length is less than 2000, which means can use O(N^2) solution
          and we use DP
        - similar to Longest Common Substring
        ========================================================
        - redo with rolling hash for practice, O(nlogn)
    */
    public int longestRepeatingSubstring(String s) {
        int n = s.length();
        int left = 1, right = n - 1;
        while (left < right) {
            // int mid = left + (right - left) / 2;
            int mid = right - (right - left) / 2; // to avoid left = 0, right = 1, infinit loop case
            if (find(s, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        //make sure there is an answer
        if (find(s, left)) {
            return left;
        } else {
            return 0;
        }
    }

    //find repeating substring with rolling hash algorithm, refacotr from the video solution a little, ref solution link
    private boolean find(String s, int len) {
        long hash = 0l;
        long base = 26; //representing the number of chars, can be more, but at least 26
        long mod = (long)1e9 + 7;
        Set<Long> seen = new HashSet<>();

        //calc the init hash code
        for (int i = 0; i < len; i++) {
            hash = (hash * base + s.charAt(i) - 'a') % mod;
        }
        seen.add(hash);

        //calc the contant value of pow(base, len)
        long pow_base_len = 1;
        for (int i = 0; i < len; i++) {
            pow_base_len = pow_base_len * base % mod;
        }

        for (int i = len; i < s.length(); i++) {
            //compute the rolling hash in O(1) time

            //add next char into the hash
            hash = (hash * base + s.charAt(i) - 'a') % mod;
            //remove the 1st char out of hash
            hash = (hash - pow_base_len * (s.charAt(i-len) - 'a') % mod + mod) % mod;
            if (seen.contains(hash)) {
                return true;
            }
            seen.add(hash);
        }

        return false;
    }
}
