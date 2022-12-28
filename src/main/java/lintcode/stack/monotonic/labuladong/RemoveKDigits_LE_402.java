package lintcode.stack.monotonic.labuladong;

import java.util.Stack;

public class RemoveKDigits_LE_402 {
    /**
     12.28.2022
     - the idea is to keep the updated digits monotonic increasing from left to right
     - if k is till > 0 after that, then remove the digits from the right, till the whole digit is 0
     - ref 东哥 post
     */
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (char c : num.toCharArray()) {
            while (stack.size() > 0 && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }
            //in case result starts from '0'
            if (stack.size() == 0 && c == '0') {
                continue;
            }
            stack.push(c);
        }
        while (stack.size() > 0 && k > 0) {
            stack.pop();
            k--;
        }

        //if stack is empty then return "0" directly
        if(stack.size() == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
