package lintcode.slidewindow;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString_LE_438_P1 {
    /**
     12.04.2022
     similar to 567, solve by 东哥 sliding window template
     ================
     3.6.2023
     P1 - similar to LE 567
     */
    public List<Integer> findAnagrams(String s, String p) {
        int[] need = new int[128];
        int[] window = new int[128];

        int count = 0;
        for (char c : p.toCharArray()) {
            if (need[c] == 0) {
                count++;
            }
            need[c]++;
        }

        int left = 0, right = 0;
        int valid = 0;
        List<Integer> res = new ArrayList<>();
        while (right < s.length()) {
            char r = s.charAt(right);
            right++;
            if (need[r] > 0) {
                window[r]++;
                if (window[r] == need[r]) {
                    valid++;
                }
            }

            while (right - left == p.length()) {
                if (valid == count) {
                    res.add(left);
                }

                char l = s.charAt(left);
                left++;
                if (need[l] > 0) {
                    if (window[l] == need[l]) {
                        valid--;
                    }
                    window[l]--;
                }
            }
        }
        return res;
    }
}
