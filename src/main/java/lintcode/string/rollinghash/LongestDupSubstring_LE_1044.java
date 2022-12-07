package lintcode.string.rollinghash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestDupSubstring_LE_1044 {
    /*
        ref https://www.youtube.com/watch?v=N7EE0VamNqc
        - lots of things to consider, level is Hard+
        - 1. binary search for the length
        - 2. using rolling hash to increase performance
        - 3. in the rolling hash, use a 26进制，do not likely in interview, but still do it for interest

    */
    Map<Integer, Integer> len2Start = new HashMap<>(); // len, start position

    public String longestDupSubstring(String s) {
        int left = 1, right = s.length() - 1; //substring length's left and right bound
        while (left < right) {
            int mid = right - (right - left) / 2; //left + (right - left) / 2 can have infinite loop in this case
            if (isOk(s, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        if (isOk(s, left)) {
            //make sure if there is an answer
            int start = len2Start.get(left);
            return s.substring(start, start + left);
        } else {
            return "";
        }
    }

    private boolean isOk(String s, int len) {
        Set<Long> set = new HashSet<>();
        long base = 36;
        long mod = (long)1e+7;
        // long mod = 1l<<32;
        long hash = 0;

        //pre calculate pow(base, len) for performance
        long pow_base_len = 1;
        for (int i = 0; i < len; i++) {
            pow_base_len = pow_base_len * base % mod;
        }

        for (int i = 0; i < s.length(); i++) {
            //count right side char into hash
            hash = (hash * base + s.charAt(i) - 'a') % mod;
            if (i >= len) {
                //when substring reach len, remove left side char out of hash
                hash = (hash - pow_base_len * (s.charAt(i-len) - 'a') % mod + mod) % mod;
            }

            //when enough in the window then count the hash
            if (i >= len - 1) {
                if (set.contains(hash)) {
                    //if found duplicate substring then record its start position
                    len2Start.put(len, i - len + 1);
                    return true;
                }
                set.add(hash);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LongestDupSubstring_LE_1044 solution = new LongestDupSubstring_LE_1044();
//        String s = "banana";//"ana"
        String s = "nnpxouomcofdjuujloanjimymadkuepightrfodmauhrsy";//"ma"
        System.out.println(solution.longestDupSubstring(s));
    }
}
