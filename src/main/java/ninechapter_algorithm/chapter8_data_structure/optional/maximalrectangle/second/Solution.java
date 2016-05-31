package ninechapter_algorithm.chapter8_data_structure.optional.maximalrectangle.second;

import java.util.Stack;

/**
 * Author: blueaken
 * Date: 5/31/16 14:03
 */
public class Solution {
    /**
     * @param matrix a boolean 2D matrix
     * @return an integer
     */
    public int maximalRectangle(boolean[][] matrix) {
        // Write your code here
        if (matrix == null || matrix.length == 0
                || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int max = 0;
        int[] height = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                height[j] = matrix[i][j] ? height[j] + 1 : 0;
            }
            max = Math.max(getMaxRectangle(height), max);
        }
        return max;
    }

    private int getMaxRectangle(int[] height) {
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
}
