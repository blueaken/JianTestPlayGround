package lintcode.stack.monotonic;

import java.util.Stack;

public class SumSubarrayMins_LE_907_MonoStack {
    /*
        Idea:
        1. use the lps dp template to found the list of sub arrays, then sum the mins
        Time - O(N^3) + O(N), simplified to O(N^3), Space - O(N^2).

        2. with Monotonic Stack, to any element A[i], found the position of PLE and NLE, then the numer of subarray between is m*n, m - the distance to PLE, n - the distance to NLE. For each subarray, the min is A[i]. A[i]*m*n is the A[i] part contribute to the answer.
        Ref - https://leetcode.com/problems/sum-of-subarray-minimums/discuss/178876/stack-solution-with-very-detailed-explanation-step-by-step
        Time - O(N + N + N), simplified to O(N), Space - O(N)

        - not ACed thought, still not fully understand the solution, visit later
    */
    public int sumSubarrayMins(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int size = arr.length;

        /*
            - Denote by left[i] the distance between element A[i] and its PLE.
            - Denote by right[i] the distance between element A[i] and its NLE.
            - Then the final answer is, sum(A[i]*left[i]*right[i] )
        */
        int left[] = new int[size];
        int right[] = new int[size];
        Stack<int[]> stack = new Stack<>();

        //PLE, start form left
        for (int i = 0; i < size; i++) {
            while (!stack.isEmpty() && stack.peek()[0] > arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? i : i - stack.peek()[1];
            stack.push(new int[] {arr[i], i});
        }
        //NLE, start from right
        stack = new Stack<>();
        for (int i = size - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] < stack.peek()[0]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? i : stack.peek()[1] - i;
            stack.push(new int[] {arr[i], i});
        }

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += arr[i] * left[i] * right[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        SumSubarrayMins_LE_907_MonoStack solution = new SumSubarrayMins_LE_907_MonoStack();
        int[] input = {3,1,2,4};//17

        System.out.println(solution.sumSubarrayMins(input));
    }
}
