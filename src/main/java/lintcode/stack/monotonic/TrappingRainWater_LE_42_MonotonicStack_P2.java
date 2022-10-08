package lintcode.stack.monotonic;

import java.util.Stack;

public class TrappingRainWater_LE_42_MonotonicStack_P2 {
    /*
        - Ref solution link and first brute force it, the idea is for each element the water it can hold is equal to the Min(left max height, right max height) - current height. Can clean up the head and tail 0 height element to improve efficient. Time is O(N^2), Space O(1)
        - DP / PrefixSum - in the Brute Force solution, left max height and right max height is calculated in each iteration, which can be improved by DB / PrefixSum. Time - O(N), Space also O(N)
        - Monotonic Stack - keep the current bar if smaller or equal to the top of stack, keep its index. If found a bar longer than top, we know the bar at the stack top is bounded by the current bar and the previous bar in the stack, hence, we can pop it and add the resulting trapped water to answer. Time also O(N), Space also O(N), but the nice thing is it only iterates the array once!
       ====================================
        10.08.2022 P2
        - Presum
        - Time O(N) with 3 iteration
      ------------------------------------
        - Monotonic Stack
        - 维持一个递减栈，遇到高的则开始Pop，并计算
        - Time O(N) with 1 iteratioin
      ====================================
    */
    public int trap(int[] height) {
        int n = height.length;
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (stack.size() > 0 && height[i] > height[stack.peek()]) {
                int top = height[stack.pop()];
                if (stack.size() == 0) {
                    break;
                }
                int curH = Math.min(height[stack.peek()], height[i]) - top;
                int curW = i - stack.peek() - 1;
                ans += curH * curW;
            }
            stack.push(i);
        }
        return ans;
    }
}
