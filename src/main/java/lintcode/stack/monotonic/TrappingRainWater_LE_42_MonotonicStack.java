package lintcode.stack.monotonic;

import java.util.Stack;

public class TrappingRainWater_LE_42_MonotonicStack {
    /*
        - Ref solution link and first brute force it, the idea is for each element the water it can hold is equal to the Min(left max height, right max height) - current height. Can clean up the head and tail 0 height element to improve efficient. Time is O(N^2), Space O(1)
        - DP / PrefixSum - in the Brute Force solution, left max height and right max height is calculated in each iteration, which can be improved by DB / PrefixSum. Time - O(N), Space also O(N)
        - Monotonic Stack - keep the current bar if smaller or equal to the top of stack, keep its index. If found a bar longer than top, we know the bar at the stack top is bounded by the current bar and the previous bar in the stack, hence, we can pop it and add the resulting trapped water to answer. Time also O(N), Space also O(N), but the nice thing is it only iterates the array once!
    */
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int ans = 0, current = 0;
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = current - stack.peek() - 1;
                int bounded_height = Math.min(height[current], height[stack.peek()]) - height[top];
                ans += distance * bounded_height;
            }
            stack.push(current++);
        }
        return ans;
    }
}
