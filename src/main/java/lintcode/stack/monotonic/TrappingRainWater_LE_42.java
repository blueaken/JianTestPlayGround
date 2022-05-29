package lintcode.stack.monotonic;

public class TrappingRainWater_LE_42 {
    /*
        - Ref solution link and first brute force it, the idea is for each element the water it can hold is equal to the Min(left max height, right max height) - current height. Can clean up the head and tail 0 height element to improve efficient. Time is O(N^2).
    */
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        //init, clean the head and tail 0 height elements & head, tail element itself
        int start = 0, end = height.length - 1;
        while (height[start] == 0) {
            start++;
        }
        if (start == 0) {
            start++;
        }

        while (height[end] == 0) {
            end--;
        }
        if (end == height.length - 1) {
            end--;
        }

        int sum = 0;
        for (int i = start; i <= end; i++) {
            int leftMax = findLeftMax(height, i);
            int rightMax = findRightMax(height, i);
            int curWater = Math.min(leftMax, rightMax) - height[i];
            if (curWater > 0) {
                sum += curWater;
            }
        }
        return sum;
    }

    private int findLeftMax(int[] height, int cur) {
        int leftMax = 0;
        while (cur >= 0) {
            leftMax = Math.max(height[cur--], leftMax);
        }
        return leftMax;
    }

    private int findRightMax(int[] height, int cur) {
        int rightMax = 0;
        while (cur < height.length) {
            rightMax = Math.max(height[cur++], rightMax);
        }
        return rightMax;
    }

    public static void main(String[] args) {
        TrappingRainWater_LE_42 solution = new TrappingRainWater_LE_42();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};//6
//        int[] height = {4,2,0,3,2,5};//9

        System.out.println(solution.trap(height));
    }
}
