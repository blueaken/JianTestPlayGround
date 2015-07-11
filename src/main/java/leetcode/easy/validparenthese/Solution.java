package leetcode.easy.validparenthese;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by jshe18 on 7/9/15.
 */
public class Solution {
    private static final Map<Character, Character> parenthesesMap = new HashMap<Character, Character>() {
        {
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }
    };

    private Stack<Character> stack = new Stack<>();

    public boolean isValid(String s) {
        Character c;
        if (s!=null && (s.length()>0)){
            for (int i=0; i<s.length(); i++){
                c = s.charAt(i);
                if (parenthesesMap.keySet().contains(c)){
                    stack.push(c);
                }else if((!stack.empty()) && parenthesesMap.get(stack.peek()).equals(c)){
                    {
                        stack.pop();
                    }
                }else {
                    return false;
                }
            }
        }

        if (stack.isEmpty()){
            return true;
        } else{
            return false;
        }
    }
}
