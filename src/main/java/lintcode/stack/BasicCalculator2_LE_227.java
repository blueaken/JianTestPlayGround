package lintcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BasicCalculator2_LE_227 {
    /*
        - iterate a stack twice
        - 1st push each operand with its previous operator into stack and calc the high pred operation before push
        - 2nd sum the reminding of the stack up
        - note in the sign case, use current sign not current char to make decision
        - it is medium level probably because it can be solved in 2 forward iteration of stack, no need to backwards
        - ref - https://www.youtube.com/watch?v=7rmxDqXf5vQ
    */
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char sign = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                //digit case
                num = num * 10 + c - '0';
            }
            if (c != ' ' && !Character.isDigit(c) || i == s.length() - 1) {
                //sign case and expression's last number handling
                if (sign == '+') {
                    stack.addLast(num);
                } else if (sign == '-') {
                    stack.addLast(-num);
                } else if (sign == '*') {
                    stack.addLast(stack.removeLast() * num);
                } else if (sign == '/') {
                    stack.addLast(stack.removeLast() / num);
                }
                num = 0;
                sign = c;
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.removeLast();
        }
        return sum;
    }

    public static void main(String[] args) {
        BasicCalculator2_LE_227 solution = new BasicCalculator2_LE_227();
        String s = "3+2*2";
        System.out.println(solution.calculate(s));
    }
}
