package lintcode.stack.monotonic;

public class TrappingRainWater_LE_42_P1 {
    /*
        - Ref solution link and first brute force it, the idea is for each element the water it can hold is equal to the Min(left max height, right max height) - current height. Can clean up the head and tail 0 height element to improve efficient. Time is O(N^2).
    */
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int start = 0;
        while (height[start] == 0) {
            start++;
        }
        if (start == 0) {
            start++;
        }

        int end = height.length - 1;
        while (height[end] == 0) {
            end--;
        }
        if (end == height.length - 1) {
            end--;
        }

        int ans = 0;
        for (int i = start; i <= end; i++) {
            int leftMax = findLeftMax(height, i);
            int rightMax = findRightMax(height, i);
            int cur = Math.min(leftMax, rightMax) - height[i];
            if (cur > 0) {
                ans += cur;
            }
        }

        return ans;
    }

    private int findLeftMax(int[] height, int index) {
        int ans = 0;
        for (int i = index; i >= 0; i--) {
            ans = Math.max(ans, height[i]);
        }
        return ans;
    }

    private int findRightMax(int[] height, int index) {
        int ans = 0;
        for (int i = index; i < height.length; i++) {
            ans = Math.max(ans, height[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        TrappingRainWater_LE_42_P1 solution = new TrappingRainWater_LE_42_P1();
//        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};//6
        int[] height = {4,2,0,3,2,5};//9

        System.out.println(solution.trap(height));
    }
}
