package lintcode.stack.labuladong;

import java.util.Stack;

public class BasicCalculator_LE_224 {
    /**
     1.24.2023
     - ref 东哥 calculator post
     - refactor with global position variable to improve performance on handling parenthesis
     */
    int pos;
    public int calculate(String s) {
        this.pos = 0;
        return helper(s);
    }

    public int helper(String s) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+'; // default to positive
        int num = 0;
        for (; pos < s.length(); pos++) {
            char c = s.charAt(pos);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            // recursive calculate the value between parenthesis, refactor with global posistion variable
            if (c == '(') {
                pos++;
                num = helper(s);
                pos++;

                if (pos < s.length()) {
                    c = s.charAt(pos);;
                }
            }

            if (!Character.isDigit(c) && c != ' ' || pos == s.length() - 1) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                }
                sign = c;
                num = 0;
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

    public static void main(String[] args) {
        BasicCalculator_LE_224 solution = new BasicCalculator_LE_224();
//        String s = "1 + 1"; //2
//        String s = "2-1 + 2"; //3
        String s = "(1+(4+5+2)-3)+(6+8)"; //23
        System.out.println(solution.calculate(s));
    }
}
