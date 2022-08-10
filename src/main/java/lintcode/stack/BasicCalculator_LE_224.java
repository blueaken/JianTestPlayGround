package lintcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BasicCalculator_LE_224 {
    public int calculate(String s) {

        int num = 0;
        int sign = 1; //default to '+', since only +/- 2 operators, 1 and -1 is enough
        int subSum = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '+') {
                subSum += num * sign;
                sign = 1;
                num = 0;
            } else if (c == '-') {
                subSum += num * sign;
                sign = -1;
                num = 0;
            } else if (c == '(') {
                //push current result and reset variables
                stack.addLast(subSum);
                stack.addLast(sign); //important

                subSum = 0;
                sign = 1;
                num = 0;
            } else if (c == ')') {
                //get current result within current parenthesis
                subSum += num * sign;
                //update with previous result and reset variables
                subSum *= stack.removeLast(); //get previous sign
                subSum += stack.removeLast(); //get previous result

                sign = 1;
                num = 0;
            }
        }

        //in case no parenthesis expression
        if (num != 0) {
            subSum += num * sign;
        }

        return subSum;
    }
}
