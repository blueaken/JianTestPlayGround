package lintcode.slidewindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString_LE_438 {
    /**
     12.04.2022
     similar to 567, solve by 东哥 sliding window template
     */
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        //build need map
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        List<Integer> res = new ArrayList<>();
        while (right < s.length()) {
            char r = s.charAt(right);
            right++;

            if (need.containsKey(r)) {
                window.put(r, window.getOrDefault(r, 0) + 1);
                if (window.get(r).equals(need.get(r))) {
                    valid++;
                }
            }

            while (right - left == p.length()) {
                if (valid == need.size()) {
                    res.add(left);
                }

                char l = s.charAt(left);
                left++;

                if (need.containsKey(l)) {
                    if (window.get(l).equals(need.get(l))) {
                        valid--;
                    }
                    window.put(l, window.get(l) - 1);

                }
            }
        }
        return res;
    }
}
