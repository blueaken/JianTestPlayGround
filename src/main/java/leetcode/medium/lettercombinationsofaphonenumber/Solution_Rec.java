package leetcode.medium.lettercombinationsofaphonenumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jshe18 on 9/23/15.
 */
public class Solution_Rec {
    private static final Map<Integer, String> DICTIONARY = new HashMap<Integer, String>(){{
        put(2, "abc");
        put(3, "def");
        put(4, "ghi");
        put(5, "jkl");
        put(6, "mno");
        put(7, "pqrs");
        put(8, "tuv");
        put(9, "wxyz");
        put(0, "");
    }};

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits==null || digits.length()==0) return result;
        StringBuilder temp = new StringBuilder();

        rec(digits, result, temp, 0);
        return result;
    }

    static void rec(String digits, List<String> result, StringBuilder temp, int position){
        if (position == digits.length()){
            result.add(temp.toString());
            return;
        }

        String letters = DICTIONARY.get(digits.charAt(position)-'0');
        for (char c : letters.toCharArray()){
            temp.append(c);
            rec(digits, result, temp, position + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public static void main(String[] args){
        List<String> res = letterCombinations("23");
        for (String s : res){
            System.out.println(s);
        }
    }
}
