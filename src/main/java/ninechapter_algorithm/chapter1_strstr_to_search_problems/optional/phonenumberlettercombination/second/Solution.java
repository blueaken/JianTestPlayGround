package ninechapter_algorithm.chapter1_strstr_to_search_problems.optional.phonenumberlettercombination.second;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: blueaken
 * Date: 4/1/16 1:57 PM
 */
public class Solution {
    public static ArrayList<String> letterCombinations(String digits) {
        // Write your code here
        ArrayList<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        Map<Character, String> map = new HashMap<>();
        map.put('0', "");
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        rec(digits, map, result, new StringBuilder(), 0);
        return result;
    }

    private static void rec(String digits, Map<Character, String> map,  ArrayList<String> result, StringBuilder sb, int start) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String cur = map.get(digits.charAt(start));
        for (int i = 0; i < cur.length(); i++) {
            sb.append(cur.charAt(i));
            rec(digits, map, result, sb, start+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        String test = "23";
        System.out.println(letterCombinations(test));
    }
}
