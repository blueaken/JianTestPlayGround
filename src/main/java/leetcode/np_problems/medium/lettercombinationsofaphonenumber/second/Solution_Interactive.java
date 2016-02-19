package leetcode.np_problems.medium.lettercombinationsofaphonenumber.second;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: blueaken
 * Date: 2/17/16 10:51 AM
 */
public class Solution_Interactive {

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
                String map = DICTIONARY.get(digits.charAt(i)-'0');
                for (int j=0; j<map.length(); j++){
                    temp.add(s + map.charAt(j));
                }
            }
            result = temp;
            temp = new ArrayList<>();
        }

        return result;
    }

    public static void main(String[] args){
        List<String> res = letterCombinations("23");
        for (String s : res){
            System.out.println(s);
        }
    }
}
