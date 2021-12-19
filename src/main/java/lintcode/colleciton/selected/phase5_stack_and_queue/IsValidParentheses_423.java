package lintcode.colleciton.selected.phase5_stack_and_queue;

import java.util.*;

public class IsValidParentheses_423 {
    /**
     * @param s: A string
     * @return: whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // write your code here
        if (s.isEmpty()) {
            return true;
        }

        Map<Character, Character> parentheses_relation = new HashMap<>();
        parentheses_relation.put('(',')');
        parentheses_relation.put('[',']');
        parentheses_relation.put('{','}');

        Set<Character> rightPar = new HashSet<>(Arrays.asList(')',']','}'));

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (parentheses_relation.keySet().contains(cur)) {
                stack.push(cur);
            }
            if (rightPar.contains(cur)) {
                if ((stack.size() > 0) && parentheses_relation.get(stack.peek()) == cur) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}
