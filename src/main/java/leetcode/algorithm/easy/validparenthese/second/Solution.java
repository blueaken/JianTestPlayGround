package leetcode.algorithm.easy.validparenthese.second;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by jshe18 on 11/9/15.
 */
public class Solution {

    private static final Map<Character, Character> parenthesesMap = new HashMap<Character, Character>() {
        {
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }
    };

    private static Stack<Character> stack = new Stack<>();

    public static boolean isValid(String s) {
        if (s!=null){
            for (Character c : s.toCharArray()){
                if (parenthesesMap.keySet().contains(c)){
                    stack.push(c);
                } else if((stack.empty()) || !parenthesesMap.get(stack.pop()).equals(c)){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }


    public static void main(String[] args){

        String test1= "({[]})";
        System.out.println("expected result for test1 is true: the actual result is: " + isValid(test1));

        String test2= "({[]}))";
        System.out.println("expected result for test2 is false: the actual result is: " + isValid(test2));

        String test3= "(";
        System.out.println("expected result for test3 is false: the actual result is: " + isValid(test3));

        String test4= "]";
        System.out.println("expected result for test4 is false: the actual result is: " + isValid(test4));
    }

}
