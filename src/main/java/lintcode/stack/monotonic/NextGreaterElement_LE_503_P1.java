package lintcode.stack.monotonic;

import java.util.Stack;

public class NextGreaterElement_LE_503_P1 {
    /*
        P1 10.10.2022
        - idea is to copy the ori arr to the arr end, then run the same nge algorithm
        - update the index mod size
        - note: 1. stack stores arr val directly; 2. mono stack need to handle equels relationship to handle duplicates
    */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();//value
        for (int i = 2*n-1; i >= 0; i--) {
            //nge - mono increasing stack
            while (stack.size() > 0 && nums[i%n] >= stack.peek()) {
                stack.pop();
            }
            res[i%n] = stack.size() == 0 ? -1 : stack.peek();
            stack.push(nums[i%n]);
        }
        return res;
    }
}
