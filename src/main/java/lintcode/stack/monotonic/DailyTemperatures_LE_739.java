package lintcode.stack.monotonic;

import java.util.Stack;

public class DailyTemperatures_LE_739 {
    /**
     12.27.2022
     - a NGE problem
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();//index
        for (int i = n - 1; i >= 0; i--) {
            //monotonic increase from back
            while (stack.size() > 0 && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            res[i] = stack.size() == 0 ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
}
