package lintcode.string.rollinghash;

import java.util.HashSet;
import java.util.Set;

public class LongestRepeatingSubstring_LE_1062_RollingHash {
    /**
     12.07.2022
     redo after study sliding window + rolling hash from 东哥 post
     */
    public int longestRepeatingSubstring(String s) {
        int start = 1, end = s.length() - 1;
        while (start < end) {
            int mid = end - (end - start) / 2;
            if (find(s, mid)) {
                start = mid;
            } else {
                end = mid-1;
            }
        }

        //verify again in case of hash collision
        if (find(s, start)) {
            return start;
        } else {
            return 0;
        }
    }

    //find by rolling hash
    private boolean find(String s, int len) {
        int R = 26;
        int RL = 1;
        for (int i = 0; i < len-1; i++) {
            RL = RL * R;
        }

        int hashVal = 0;
        Set<Integer> seen = new HashSet<>();

        int left = 0, right = 0;
        while (right < s.length()) {
            //add new char into low position
            hashVal = hashVal * R + s.charAt(right) - 'a';
            right++;

            while (right - left == len) {
                if (seen.contains(hashVal)) {
                    return true;
                }
                seen.add(hashVal);

                //remove the leftmost char
                hashVal = hashVal - (s.charAt(left) - 'a') * RL;
                left++;
            }
        }
        return false;
    }
}
