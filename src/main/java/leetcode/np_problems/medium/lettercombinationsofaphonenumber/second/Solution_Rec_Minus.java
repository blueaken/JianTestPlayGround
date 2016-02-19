package leetcode.np_problems.medium.lettercombinationsofaphonenumber.second;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: blueaken
 * Date: 2/17/16 9:43 AM
 */
public class Solution_Rec_Minus {

    private static final Map<Character, String> DICTIONARY = new HashMap<Character, String>(){{
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

    private static List<String> result = new ArrayList<>();

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return result;

        rec(digits, digits.length()-1);
        return result;
    }

    private static void rec(String digits, int index){
        if (index == -1) {
            result.add("");
            return;
        }

        rec(digits, index-1);
        int size = result.size();
        List<String> temp = new ArrayList<>();
        for (int i=0; i<size; i++){
            String mapString = DICTIONARY.get(digits.charAt(index));
            for (int j=0; j<mapString.length(); j++){
                temp.add(result.get(i) + mapString.charAt(j));
            }
        }
        result = temp;
    }

    public static void main(String[] args){
        List<String> res = letterCombinations("23");
        for (String s : res){
            System.out.println(s);
        }
    }
}
