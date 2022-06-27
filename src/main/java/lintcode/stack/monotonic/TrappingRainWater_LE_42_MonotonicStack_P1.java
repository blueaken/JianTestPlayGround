package lintcode.stack.monotonic;

import java.util.Stack;

public class TrappingRainWater_LE_42_MonotonicStack_P1 {
    /*
        - Ref solution link and first brute force it, the idea is for each element the water it can hold is equal to the Min(left max height, right max height) - current height. Can clean up the head and tail 0 height element to improve efficient. Time is O(N^2), Space O(1)
        - DP / PrefixSum - in the Brute Force solution, left max height and right max height is calculated in each iteration, which can be improved by DB / PrefixSum. Time - O(N), Space also O(N)
        - Monotonic Stack - keep the current bar if smaller or equal to the top of stack, keep its index. If found a bar longer than top, we know the bar at the stack top is bounded by the current bar and the previous bar in the stack, hence, we can pop it and add the resulting trapped water to answer. Time also O(N), Space also O(N), but the nice thing is it only iterates the array once!
    */
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int ans = 0;
        Stack<Integer> stack = new Stack<>(); //index
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = i - stack.peek() - 1;
                int boundedHeight = Math.min(height[stack.peek()], height[i]) - height[top];
                ans += boundedHeight * distance;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        TrappingRainWater_LE_42_MonotonicStack_P1 solution = new TrappingRainWater_LE_42_MonotonicStack_P1();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};//6
//        int[] height = {4,2,0,3,2,5};//9

        System.out.println(solution.trap(height));
    }
}
