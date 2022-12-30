package lintcode.stack.monotonic;

import java.util.Stack;

public class LargestRectangleInHistogram_LE_084_MonotonicStack_P1 {
    /*
        - similar to 042, almost opposite algorithm
        - maintain a monotonic increase stack, when hit a lower bar start count the the area in the middle
        - a trick is adding a '0' at both ends of the arr to ensure the first and last bar area be counted, considering this, this problem is slightly more diffifult than 042
        --------------------------------
        - similar to 042, this problem can also be solved with presum
        - count leftLess and rightLess pos for each element
        - for each pos calc (rightLess - leftPoss - 1) * cur height and return the max
        - although it need 3 iteration, but still much faster than monotonic stack, since each step the calc is much straightforward
        ====================================
        12.30.2022 Motonic Stack P1
    */
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nums = new int[n+2];
        nums[0] = 0; nums[n+1] = 0;
        for (int i = 0; i < n; i++) {
            nums[i+1] = heights[i];
        }

        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i <= n+1; i++) {
            while (stack.size() > 0 && nums[stack.peek()] > nums[i]) {
                int top = nums[stack.pop()];
                int curW = i - stack.peek() - 1;
                ans = Math.max(ans, curW * top);
            }
            stack.push(i);
        }
        return ans;
    }
}
