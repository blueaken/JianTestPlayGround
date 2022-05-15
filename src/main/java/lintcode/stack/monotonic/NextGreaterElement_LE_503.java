package lintcode.stack.monotonic;

import java.util.Stack;

public class NextGreaterElement_LE_503 {
    /*
      - a brute force solution is to copy the arr to the end, then apply the same solution as Next Greater Element I.
      - for the monotonic stack solution, try the % operator to assume such an array exists
    */
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int size = nums.length;
        int[] res = new int[size];

        for (int i = 2 * size - 1; i >= 0; i--) {
            //maintian monotonic stack
            while (!stack.isEmpty() && nums[i % size] >= stack.peek()) {
                stack.pop();
            }
            //update result array
            res[i % size] = stack.isEmpty() ? -1 : stack.peek();
            //push current element
            stack.push(nums[i % size]);
        }

        return res;
    }
}
