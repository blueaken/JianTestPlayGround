package lintcode.stack.monotonic;

import java.util.Stack;

public class MaximalRectangle_LE_085 {
    /*
        084 variant
        - transfer 2D matrix to 1D hist array line by line
        - calc largest rectangle for each hist array - same algorithm as 084
        - Time: O(M*N)
    */
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] hist = new int[n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    hist[j]++;
                } else {
                    hist[j] = 0;
                }
            }
            ans = Math.max(ans, calcMaxRectangle(hist));
        }
        return ans;
    }

    private int calcMaxRectangle(int[] hist) {
        int n = hist.length;
        int[] nums = new int[n+2];
        for (int i = 0; i < n; i++) {
            nums[i+1] = hist[i];
        }

        Stack<Integer> stack = new Stack<>();//index
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            //mono increasing stack
            while (stack.size() > 0 && nums[i] < nums[stack.peek()]) {
                int top = nums[stack.pop()];
                int curW = i - stack.peek() - 1;
                ans = Math.max(ans, top * curW);
            }
            stack.push(i);
        }
        return ans;
    }
}
