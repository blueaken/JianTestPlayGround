package lintcode.stack.labuladong;

import java.util.Stack;

public class BasicCalculator3_LE_772 {
    /**
     1.25.2023
     - ref 东哥 calculator framework
     - refactor with global position variable to improve parenthsis handling efficiency
     */
    int pos;
    public int calculate(String s) {
        this.pos = 0;
        return helper(s);
    }

    public int helper(String s) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;

        for (; pos < s.length(); pos++) {
            char c = s.charAt(pos);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (c == '(') {
                pos++;
                num = helper(s);
                pos++;

                if (pos < s.length()) {
                    c = s.charAt(pos);
                }
            }

            if (!Character.isDigit(c) && c != ' ' || pos == s.length() - 1) {
                switch(sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                num = 0;
                sign = c;
            }

            if (c == ')') {
                break;
            }
        }

        int res = 0;
        while (stack.size() > 0) {
            res += stack.pop();
        }
        return res;
    }
}
