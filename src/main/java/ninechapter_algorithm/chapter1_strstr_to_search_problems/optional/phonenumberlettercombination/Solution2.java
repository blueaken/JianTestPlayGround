package ninechapter_algorithm.chapter1_strstr_to_search_problems.optional.phonenumberlettercombination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: blueaken
 * Date: 3/24/16 8:37 PM
 */
public class Solution2 {
    /**
     * @param digits A digital string
     * @return all posible letter combinations
     */

    private static Map<Character, String> map = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
        put('0', "");
    }};

    public static ArrayList<String> letterCombinations(String digits) {
        // Write your code here
        ArrayList<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        StringBuilder sb = new StringBuilder();
        rec(digits, result, sb, 0);
        return result;
    }

    private static void rec(String digits, ArrayList<String> result, StringBuilder sb, int start) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String current = map.get(digits.charAt(start));
        for (int i = 0; i < current.length(); i++) {
            sb.append(current.charAt(i));
            rec(digits, result, sb, start+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        String test = "234";
        System.out.println(letterCombinations(test));
    }
}
