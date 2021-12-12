package lintcode.colleciton.selected.phase3_array;

import java.util.HashMap;
import java.util.Map;

public class LargestLetter_353 {
    /**
     * @param s: a string
     * @return: a string
     */
    public String largestLetter(String s) {
        // write your code here
        Map<Character, Boolean> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), true);
        }

        String result = "NO";
        for (char c = 'a'; c <= 'z'; c++) {
            if (map.get(c) != null) {
                char upp = Character.toUpperCase(c);
                if (map.get(upp) != null) {
                    if (result.equals("NO") || upp > result.charAt(0)) {
                        result = String.valueOf(upp);
                    }
                }
            }
        }
        return result;
    }
}
