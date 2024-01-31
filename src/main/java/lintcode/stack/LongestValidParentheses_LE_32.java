package lintcode.stack;

import java.util.Stack;

public class LongestValidParentheses_LE_32 {
    /**
     1.31.24
     ref 东哥 post
     */
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>(); // store pos index
        int n = s.length(), max = 0;
        int[] dp = new int[n+1]; // dp[i] = 以i-1结尾substring的最大长度
        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            if (cur == '(') {
                stack.push(i);
                dp[i+1] = 0; //左括号位置长度只能为0
            } else if (stack.size() > 0) {
                int leftIdx = stack.pop();
                int curLen = i - leftIdx + 1 + dp[leftIdx];
                dp[i+1] = curLen;
                max = Math.max(max, curLen);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestValidParentheses_LE_32 solution = new LongestValidParentheses_LE_32();
        System.out.println(solution.longestValidParentheses("()()"));
    }
}
