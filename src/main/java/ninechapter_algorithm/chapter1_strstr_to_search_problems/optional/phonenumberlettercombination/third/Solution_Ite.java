package ninechapter_algorithm.chapter1_strstr_to_search_problems.optional.phonenumberlettercombination.third;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: blueaken
 * Date: 6/20/16 09:27
 */
public class Solution_Ite {
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

        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            String cur = map.get(digits.charAt(i));
            ArrayList<String> temp = new ArrayList<>();
            for (int j = 0; j < result.size(); j++) {
                for (int k = 0; k < cur.length(); k++) {
                    temp.add(result.get(j) + cur.charAt(k));
                }
            }
            result = temp;
        }

        return result;
    }
}
