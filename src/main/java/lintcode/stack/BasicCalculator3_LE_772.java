package lintcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BasicCalculator3_LE_772 {
    /*
        - combine the 224 and 227
        - use recursion to solve parentheses case
        - ref https://www.youtube.com/watch?v=7rmxDqXf5vQ
        - Time still O(N)
    */
    public int calculate(String s) {

        int number = 0;
        char sign = '+';
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            }

            if (c == '(') {
                //find the substring between parentheses
                int left = 1;
                int j = i + 1;
                while (left > 0) {
                    if (s.charAt(j) == '(') {
                        left++;
                    } else if (s.charAt(j) == ')') {
                        left--;
                        //avoid j++ when the last parentheses found
                        if (left == 0) {
                            break;
                        }
                    }
                    j++;
                }
                number = calculate(s.substring(i+1, j));
                i = j;
            }

            if (c != ' ' && !Character.isDigit(c) || i == s.length() - 1) {
                if (sign == '+') {
                    stack.addLast(number);
                } else if (sign == '-') {
                    stack.addLast(-number);
                } else if (sign == '*') {
                    stack.addLast(stack.removeLast() * number);
                } else if (sign == '/') {
                    stack.addLast(stack.removeLast() / number);
                }

                sign = c;
                number = 0;
            }
        }

        int sum  = 0;
        while (!stack.isEmpty()) {
            sum += stack.removeLast();
        }
        return sum;
    }

    public static void main(String[] args) {
        BasicCalculator3_LE_772 solution = new BasicCalculator3_LE_772();
//        String s = "6-4/2";//4
        String s = "2*(5+5*2)/3+(6/2+8)";//21

        System.out.println(solution.calculate(s));
    }
}
