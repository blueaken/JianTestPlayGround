package leetcode.algorithm.easy.validparenthese;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by jshe18 on 7/10/15.
 */
public class Solution_Refactored {
    private static final Map<Character, Character> parenthesesMap = new HashMap<Character, Character>() {
        {
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }
    };

    private Stack<Character> stack = new Stack<>();

    public boolean isValid(String s) {
        if (s!=null && (s.length()>0)){
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
}
