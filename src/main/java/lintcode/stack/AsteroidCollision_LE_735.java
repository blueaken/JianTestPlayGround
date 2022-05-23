package lintcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision_LE_735 {
    /*
        - Time O(N), Space O(N)
    */
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            int cur = asteroids[i];

            //note the [-1, 1] case is tricky, -1 moves left and 1 moves right, which does not collide
            while (!stack.isEmpty()
                    && stack.peek() * cur < 0
                    && cur < 0
                    && Math.abs(stack.peek()) < Math.abs(cur)) {
                stack.pop();
            }

            if (stack.isEmpty() || stack.peek() * cur > 0 || cur > 0) {
                stack.push(cur);
            } else if (Math.abs(stack.peek()) == Math.abs(cur)) {
                stack.pop();
            }

            //other case - Math.abs(stack.peek()) > Math.abs(cur) just ignore the cur and continue the loop
        }

        int[] res = new int[stack.size()];
        for (int i = res.length -1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        AsteroidCollision_LE_735 solution = new AsteroidCollision_LE_735();
        int[] asteroids = {5, 10, -5};
        System.out.println(Arrays.toString(solution.asteroidCollision(asteroids)));
    }
}
