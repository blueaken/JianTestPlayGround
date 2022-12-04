package lintcode.slidewindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters_LE_3 {
    /**
     12.04.2022
     redo ref 东哥 sliding window template
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int res = 0;
        int n = s.length();
        if (n == 0) {
            return res;
        }

        int left = 0, right = 0;
        while (right < n) {
            char r = s.charAt(right);
            right++;

            window.put(r, window.getOrDefault(r, 0) + 1);

            while (window.get(r) > 1) {
                char l = s.charAt(left);
                left++;

                if (window.containsKey(l)) {
                    window.put(l, window.get(l) - 1);
                }
            }

            res = Math.max(res, right - left);
        }
        return res;
    }
}
