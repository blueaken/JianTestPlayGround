package lintcode.stack.labuladong;

import java.util.Stack;

public class BasicCalculator_LE_224 {
    /**
     1.24.2023
     ref 东哥 post
     */
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+'; // default to positive
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            // recursive calculate the value between parenthesis
            if (c == '(') {
                int left = 1;
                int j = i + 1;
                while (left > 0) {
                    char cur = s.charAt(j);
                    if (cur == '(') {
                        left++;
                    } else if (cur == ')') {
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
