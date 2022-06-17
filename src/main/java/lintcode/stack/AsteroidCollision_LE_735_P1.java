package lintcode.stack;

import java.util.Stack;

public class AsteroidCollision_LE_735_P1 {
    /*
        - Time O(N), Space O(N)
        - refactor ref - https://leetcode.com/problems/asteroid-collision/discuss/193403/Java-easy-to-understand-solution
    */
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        //note the [-1, 1] case is tricky, -1 moves left and 1 moves right, which does not collide
        for (int i : asteroids) {
            if (i > 0) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(i)) {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(i);
                } else if (stack.peek() + i == 0) {
                    //case collision of same size
                    stack.pop();
                }
            }
        }

        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
