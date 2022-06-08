package lintcode.stack.monotonic;

import java.util.Stack;

public class SubArrayRanges_LE_2104 {
    /*
        - nums.length <= 1000, brute force is a fit, Time - O(N^3)
        - try the O(N) time with monotonic stack, the idea is for each array element, calculate the value * (maximum occurrences - minimum occurrences), then sum up and get the result.
        - to get the maximum and minimum occurences, use the solution from 907, with the help of monotonic stack
    */
    public long subArrayRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0L;
        }
        int size = nums.length;

        //step 1. for each array element calculate the PLE and NLE, for the minimum occurrence
        Stack<int[]> stack = new Stack<>();
        long[] left_less = new long[size];
        for (int i = 0; i < size; i++) {
            while (!stack.isEmpty() && stack.peek()[0] >= nums[i]) {
                stack.pop();
            }
            left_less[i] = stack.isEmpty() ? i + 1 : i - stack.peek()[1];
            stack.push(new int[] {nums[i], i});
        }
        stack.clear();

        long[] right_less = new long[size];
        for (int i = size - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek()[0] > nums[i]) {
                stack.pop();
            }
            right_less[i] = stack.isEmpty() ? size - i : stack.peek()[1] - i;
            stack.push(new int[] {nums[i], i});
        }
        stack.clear();

        //step 2. for each array element calculate the PGE and NGE, for the maximum occurrence
        long[] left_greater = new long[size];
        for (int i = 0; i < size; i++) {
            while (!stack.isEmpty() && stack.peek()[0] <= nums[i]) {
                stack.pop();
            }
            left_greater[i] = stack.isEmpty() ? i + 1 : i - stack.peek()[1];
            stack.push(new int[] {nums[i], i});
        }
        stack.clear();

        long[] right_greater = new long[size];
        for (int i = size - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek()[0] < nums[i]) {
                stack.pop();
            }
            right_greater[i] = stack.isEmpty() ? size - i : stack.peek()[1] - i;
            stack.push(new int[] {nums[i], i});
        }
        stack.clear();

        //step 3. calculate the sum from the previous 2 results
        long sum = 0;
        for (int i = 0; i < size; i++) {
            sum += nums[i] * (left_greater[i] * right_greater[i] - left_less[i] * right_less[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        SubArrayRanges_LE_2104 solution = new SubArrayRanges_LE_2104();
        int[] nums = {1,2,3}; //4
        //        int[] nums = {4,-2,-3,4,1}; //59

        System.out.println(solution.subArrayRanges(nums));
    }
}
