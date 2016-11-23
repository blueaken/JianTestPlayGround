package leetcode.algorithm.np_problems.medium.lettercombinationsofaphonenumber.second;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: blueaken
 * Date: 2/18/16 2:17 PM
 */
public class Solution_Rec_Plus {

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

        StringBuilder temp = new StringBuilder();
        rec(digits, 0, temp);
        return result;
    }

    private static void rec(String digits, int index, StringBuilder temp){
        if (index == digits.length()){
            result.add(temp.toString());
            return;
        }

        String map = DICTIONARY.get(digits.charAt(index));
        for (int i=0; i<map.length(); i++){
            temp.append(map.charAt(i));
            rec(digits, index+1, temp);
            temp.deleteCharAt(temp.length()-1);
        }
    }

    public static void main(String[] args){
        List<String> res = letterCombinations("23");
        for (String s : res){
            System.out.println(s);
        }
    }
}
