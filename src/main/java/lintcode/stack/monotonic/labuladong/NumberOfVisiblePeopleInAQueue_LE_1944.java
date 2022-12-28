package lintcode.stack.monotonic.labuladong;

import java.util.Stack;

public class NumberOfVisiblePeopleInAQueue_LE_1944 {
    /**
     12.27.2022
     - use nge template
     - count右侧比自己矮的人(身高处于单调升高)，并且最后count右侧最高的人如果Stack不为空
     */
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int[] res = new int[n];
        //nge template
        for (int i = n - 1; i >= 0; i--) {
            int count = 0;
            while (stack.size() > 0 && stack.peek() < heights[i]) {
                stack.pop();
                count++; // ith people can see all people to the right whose height is less its own height and of monotonic increasing
            }

            // when stack is not empty ith people can see that people whose height is greater than or equal to its height
            if (stack.size() > 0) {
                count++;
            }
            res[i] = count;
            stack.push(heights[i]);
        }
        return res;
    }
}
