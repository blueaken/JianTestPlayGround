package lintcode.stack.monotonic;

import java.util.Stack;

public class RemoveDuplicateLetters_LE_316 {
    /**
     12.18.2022
     ref 东哥 post
     - the trick is how to keep lexicographical order, solve by monotonic stack template
     */
    public String removeDuplicateLetters(String s) {
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        boolean[] inStack = new boolean[256];
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            //remove current char's count in each iteration
            count[c]--;

            if (inStack[c]) {
                continue;
            }

            //maintain a monotonic increasing stack
            while (stack.size() != 0 && stack.peek() > c) {
                if (count[stack.peek()] == 0) {
                    break;
                }

                inStack[stack.pop()] = false;
            }
            stack.push(c);
            inStack[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
