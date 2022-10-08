package lintcode.stack.monotonic;

public class TrappingRainWater_LE_42_PrefixSum_P2 {
    /*
        - Ref solution link and first brute force it, the idea is for each element the water it can hold is equal to the Min(left max height, right max height) - current height. Can clean up the head and tail 0 height element to improve efficient. Time is O(N^2), Space O(1)
        - DP / PrefixSum - in the Brute Force solution, left max height and right max height is calculated in each iteration, which can be improved by DB / PrefixSum. Time - O(N), Space also O(N)
        - Monotonic Stack - keep the current bar if smaller or equal to the top of stack, keep its index. If found a bar longer than top, we know the bar at the stack top is bounded by the current bar and the previous bar in the stack, hence, we can pop it and add the resulting trapped water to answer. Time also O(N), Space also O(N), but the nice thing is it only iterates the array once!
       ====================================
        10.08.2022 P2
        - Presum
        - Time O(N) with 3 iteration
    */
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n-1] = height[n-1];
        for (int i = n-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cur = Math.min(leftMax[i], rightMax[i]) - height[i];
            if (cur > 0) {
                ans += cur;
            }
        }
        return ans;
    }
}
