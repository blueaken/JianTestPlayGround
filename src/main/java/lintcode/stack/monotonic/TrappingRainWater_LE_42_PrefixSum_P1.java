package lintcode.stack.monotonic;

public class TrappingRainWater_LE_42_PrefixSum_P1 {
    /*
        - Ref solution link and first brute force it, the idea is for each element the water it can hold is equal to the Min(left max height, right max height) - current height. Can clean up the head and tail 0 height element to improve efficient. Time is O(N^2).
        - DP / PrefixSum - in the Brute Force solution, left max height and right max height is calculated in each iteration, which can be improved by DB / PrefixSum. Time - O(N)
    */
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int start = 0;
        while (height[start] == 0) {
            start++;
        }
        int end = height.length - 1;
        while (height[end] == 0) {
            end--;
        }

        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        int[] rightMax = new int[height.length];
        rightMax[height.length-1] = height[height.length-1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        int ans = 0;
        for (int i = start; i <= end; i++) {
            int cur = Math.min(leftMax[i], rightMax[i]) - height[i];
            if (cur > 0) {
                ans += cur;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TrappingRainWater_LE_42_PrefixSum_P1 solution = new TrappingRainWater_LE_42_PrefixSum_P1();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};//6
//        int[] height = {4,2,0,3,2,5};//9

        System.out.println(solution.trap(height));
    }
}
