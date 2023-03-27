package lintcode.stack.monotonic;

import java.util.Stack;

public class RemoveDuplicateLetters_LE_316_P1 {
    /**
     12.18.2022
     ref 东哥 post
     - the trick is how to keep lexicographical order, solve by monotonic stack template
     ==============
     03.27.2023
     P1
     */
    public String removeDuplicateLetters(String s) {
        int[] count = new int[256];
        for (char cur : s.toCharArray()) {
            count[cur]++;
        }

        Stack<Character> stack = new Stack<>();
        boolean[] inStack = new boolean[256];
        for (char cur : s.toCharArray()) {
            count[cur]--;

            if (inStack[cur]) {
                continue;
            }

            while (stack.size() > 0 && stack.peek() > cur) {
                if (count[stack.peek()] == 0) {
                    break;
                }

                inStack[stack.pop()] = false;
            }
            stack.push(cur);
            inStack[cur] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
