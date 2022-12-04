package lintcode.slidewindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString_LE_567 {
    /**
     12.04.2022
     ref 东哥 post
     similar to 76, sliding window type
     */
    public boolean checkInclusion(String s1, String s2) {
        //similar to 76, if s2 contains a substring including all chars with same number from s1
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        //init need map
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char r = s2.charAt(right);
            right++;

            if (need.containsKey(r)) {
                window.put(r, window.getOrDefault(r, 0) + 1);
                if (window.get(r).equals(need.get(r))) {
                    valid++;
                }
            }

            //window shrinks when the size is equals to the s1 size
            while (right - left == s1.length()) {
                if (valid == need.size()) {
                    return true;
                }

                char l = s2.charAt(left);
                left++;

                if (need.containsKey(l) && window.containsKey(l)) {
                    if (window.get(l).equals(need.get(l))) {
                        valid--;
                    }
                    window.put(l, window.get(l) - 1);
                }

            }

        }
        return false;
    }
}
