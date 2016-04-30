package ninechapter_algorithm.chapter8_data_structure.largestrectangleinhistogram;

import java.util.Stack;

/**
 * Author: blueaken
 * Date: 4/30/16 10:56
 */
public class Solution_IncreasingStack {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public static int largestRectangleArea(int[] height) {
        // write your code here
        if (height == null || height.length == 0) {
            return 0;
        }

        //Increasing Stack O(n)
        int best = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= height.length; i++) {
            int cur = (i == height.length) ? -1 : height[i];
            while (!stack.isEmpty() && cur <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                best = Math.max(h * w, best);
            }
            stack.push(i);
        }
        return best;
    }

    public static void main(String[] args) {
        int[] test = {2,1,5,6,2,3};

        System.out.println(largestRectangleArea(test));
    }

}
