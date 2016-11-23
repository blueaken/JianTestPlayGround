package ninechapter_algorithm.chapter1_strstr_to_search_problems.optional.phonenumberlettercombination.third;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: blueaken
 * Date: 6/20/16 08:49
 */
public class Solution_Rec {
    /**
     * @param digits A digital string
     * @return all posible letter combinations
     */
    public ArrayList<String> letterCombinations(String digits) {
        // Write your code here
        ArrayList<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        map.put('0', "");

        rec(digits, map, new StringBuilder(), 0, result);
        return result;
    }

    private void rec(String digits, Map<Character, String> map, StringBuilder sb,
                     int start, ArrayList<String> result) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String cur = map.get(digits.charAt(start));
        for (int i = 0; i < cur.length(); i++) {
            sb.append(cur.charAt(i));
            rec(digits, map, sb, start + 1, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
