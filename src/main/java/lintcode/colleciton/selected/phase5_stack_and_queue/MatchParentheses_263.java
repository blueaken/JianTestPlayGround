package lintcode.colleciton.selected.phase5_stack_and_queue;

import java.util.Stack;

public class MatchParentheses_263 {
    /**
     * @param string: A string
     * @return: whether the string is a valid parentheses
     */
    //Key Idea: same as 423
    public boolean matchParentheses(String string) {
        // write your code here
        if (string.isEmpty()) return true;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < string.length(); i++) {
            char cur = string.charAt(i);
            if (cur == '(') {
                stack.push(cur);
            } else if (cur == ')') {
                if (stack.size() == 0 || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.size() == 0;
    }
}
