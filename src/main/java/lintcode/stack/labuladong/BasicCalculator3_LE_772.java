package lintcode.stack.labuladong;

import java.util.Stack;

public class BasicCalculator3_LE_772 {
    /**
     1.25.2023
     ref 东哥 calculator framework
     */
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (c == '(') {
                int left = 1;
                int j = i + 1;
                while (left > 0) {
                    char d = s.charAt(j);
                    if (d == '(') {
                        left++;
                    }
                    if (d == ')') {
                        left--;
                        if (left == 0) {
                            break;
                        }
                    }
                    j++;
                }
                num = calculate(s.substring(i+1, j));
                i = j;
            }
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
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
        }

        int res = 0;
        while (stack.size() > 0) {
            res += stack.pop();
        }
        return res;
    }
}
