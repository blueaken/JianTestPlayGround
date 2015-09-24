package leetcode.medium.lettercombinationsofaphonenumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jshe18 on 9/23/15.
 */
public class Solution_NoRec {

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

        List<String> temp = new ArrayList<>();
        result.add("");

        for (int i=0; i<digits.length(); i++){
            for (String s : result){
                String letters = DICTIONARY.get(digits.charAt(i)-'0');
                for (int j=0; j<letters.length(); j++){
                    temp.add(s + letters.charAt(j));
                }
            }
            result = temp;
            temp = new ArrayList<>();
        }

        return result;
    }

    public static void main(String[] args){
        List<String> res = letterCombinations("234");
        for (String s : res){
            System.out.println(s);
        }
    }
}
