package lintcode.stack.labuladong;

import java.util.Stack;

public class BasicCalculator2_LE_227 {
    /**
     1.25.2023
     ref 东哥 calculator 框架
     */
    public int calculate(String s) {
        char sign = '+';
        Stack<Integer> stack = new Stack<>();

        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                switch (sign) {
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
        }

        int res = 0;
        while (stack.size() > 0) {
            res += stack.pop();
        }
        return res;
    }
}
