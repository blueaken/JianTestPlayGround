package ninechapter_algorithm.chapter8_data_structure.largestrectangleinhistogram.second;


import java.util.Stack;

/**
 * Author: blueaken
 * Date: 5/31/16 10:52
 */
public class Solution_IncreadingStack {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        if (height ==  null || height.length == 0) {
            return 0;
        }

        int best = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= height.length; i++) {
            int cur = i == height.length ? -1 : height[i];
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
        int[] test = {5,4,1,2};
        Solution_IncreadingStack solution = new Solution_IncreadingStack();
        System.out.println(solution.largestRectangleArea(test));
    }
}
