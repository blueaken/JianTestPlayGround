package lintcode.stack.monotonic;

import java.util.Stack;

public class LargestRectangleInHistogram_LE_084_MonotonicStack {
    /*
        - similar to 042, almost opposite algorithm
        - maintain a monotonic increase stack, when hit a lower bar start count the the area in the middle
        - a trick is adding a '0' at both ends of the arr to ensure the first and last bar area be counted, considering this, this problem is slightly more difficult than 042
    */
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nums = new int[n+2];
        nums[0] = 0;
        nums[n+1] = 0;
        //stuff 0 to both ends to ensure first and last bar got calculated
        for (int i = 0; i < n; i++) {
            nums[i+1] = heights[i];
        }

        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i <= n+1; i++) {
            while (stack.size() > 0 && nums[i] < nums[stack.peek()]) {
                int top = nums[stack.pop()];
                // if (stack.size() == 0) { //can skip this check since 0 is stuffed in the head
                //     break;
                // }
                int curW = i - stack.peek() - 1;
                ans = Math.max(ans, curW * top);
            }
            stack.push(i);
        }
        return ans;
    }
}
