package lintcode.stack.monotonic;

public class LargestRectangleInHistogram_LE_084_PrefixSum {
    /*
        - similar to 042, almost opposite algorithm
        - maintain a monotonic increase stack, when hit a lower bar start count the the area in the middle
        - a trick is adding a '0' at both ends of the arr to ensure the first and last bar area be counted, considering this, this problem is slightly more diffifult than 042
        --------------------------------
        - similar to 042, this problem can also be solved with presum
        - count leftLess and rightLess pos for each element
        - for each pos calc (rightLess - leftPoss - 1) * cur height and return the max
        - although it need 3 iteration, but still much faster than monotonic stack, since each step the calc is much straightforward
    */
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftLess = new int[n];
        leftLess[0] = -1;
        for (int i = 1; i < n; i++) {
            int left = i - 1;
            while (left >= 0 && heights[left] >= heights[i]) {
                left = leftLess[left];
            }
            leftLess[i] = left;
        }

        int[] rightLess = new int[n];
        rightLess[n-1] = n;
        for (int i = n - 2; i >= 0; i--) {
            int right = i + 1;
            while (right < n && heights[right] >= heights[i]) {
                right = rightLess[right];
            }
            rightLess[i] = right;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cur = heights[i] * (rightLess[i] - leftLess[i] - 1);
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
