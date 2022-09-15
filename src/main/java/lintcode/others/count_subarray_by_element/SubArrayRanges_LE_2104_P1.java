package lintcode.others.count_subarray_by_element;

import java.util.Stack;

    /*
        - nums.length <= 1000, brute force is a fit, with lps dp template, Time - O(N^3)
        - try the O(N) time with monotonic stack, the idea is for each array element, calculate the value * (maximum occurrences - minimum occurrences), then sum up and get the result.
        - to get the maximum and minimum occurrences, use the solution from 907, with the help of monotonic stack
    */
    public class SubArrayRanges_LE_2104_P1 {
        public long subArrayRanges(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0L;
            }

            int size = nums.length;
            Stack<int[]> stack = new Stack<>();
            //step 1. calculate the minimum occurrence
            long[] left_less = new long[size];
            for (int i = 0; i < nums.length; i++) {
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

            //step 2. calculate the maximum occurrence
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

            //step 3. calculate the range sum from the previous result
            long sum = 0L;
            for (int i = 0; i < size; i++) {
                sum += nums[i] * (left_greater[i] * right_greater[i] - left_less[i] * right_less[i]);
            }
            return sum;
        }

        public static void main(String[] args) {
            SubArrayRanges_LE_2104_P1 solution = new SubArrayRanges_LE_2104_P1();
//            int[] nums = {1,2,3}; //4
            int[] nums = {4,-2,-3,4,1}; //59

            System.out.println(solution.subArrayRanges(nums));
        }
}
