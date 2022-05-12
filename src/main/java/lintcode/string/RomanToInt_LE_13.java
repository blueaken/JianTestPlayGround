package lintcode.string;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt_LE_13 {
    /*
     Warm up for Int to Roman, Time: O(1), since there is finite set of roman numerals, the max possible
     number is 3999. If roman numbers has an arbitrary set, the time would be O(N).
    */
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0, prev = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int cur = map.get(s.charAt(i));
            if (cur == 1 && (prev == 5 || prev == 10)
                    || cur == 10 && (prev == 50 || prev == 100)
                    || cur == 100 && (prev == 500 || prev == 1000)) {
                res -= cur;
            } else {
                res += cur;
            }
            prev = cur;
        }
        return res;
    }
}
