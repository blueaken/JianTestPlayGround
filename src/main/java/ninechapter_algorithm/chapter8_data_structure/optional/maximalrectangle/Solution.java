package ninechapter_algorithm.chapter8_data_structure.optional.maximalrectangle;

import java.util.Stack;

/**
 * Author: blueaken
 * Date: 4/30/16 15:51
 */
public class Solution {
    /**
     * @param matrix a boolean 2D matrix
     * @return an integer
     */
    public static int maximalRectangle(boolean[][] matrix) {
        // Write your code here
        if (matrix == null || matrix.length == 0
                || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int best = 0;
        int[] height = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                height[j] = matrix[i][j] ? height[j] + 1 : 0;
            }
            best = Math.max(getMaxRectangle(height), best);
        }

        return best;
    }

    private static int getMaxRectangle(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int best = 0;
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
        boolean test[][] = {
                { true, true, false, false, true},
                { false, true, false, false, true},
                { false, false, true, true, true},
                { false, false, true, true, true},
                { false, false, false, false, true}
        };

        System.out.println(maximalRectangle(test));
    }
}
