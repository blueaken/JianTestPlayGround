package lintcode.stack.monotonic;

import java.util.Stack;

public class SumSubarrayMins_LE_907_MonoStack_Index_Based {
    /*
        Idea:
        1. use the lps dp template to found the list of sub arrays, then sum the mins
        Time - O(N^3) + O(N), simplified to O(N^3), Space - O(N^2).

        2. with Monotonic Stack, to any element A[i], found the position of PLE and NLE, then the number of subarray between is m*n, m - the distance to PLE, n - the distance to NLE. For each subarray, the min is A[i]. A[i]*m*n is the A[i] part contribute to the answer.
        Ref - https://leetcode.com/problems/sum-of-subarray-minimums/discuss/178876/stack-solution-with-very-detailed-explanation-step-by-step
        Time - O(N + N + N), simplified to O(N), Space - O(N)

        - not ACed thought, still not fully understand the solution, visit later
        - update it to index based 8.7.2022
    */
    public int sumSubarrayMins(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int size = arr.length;
         /*
            - find the ple & nle with the help of monotonic stack
            - Then the final answer is, sum(arr[i]* (i - ple[i]) * (nle[i] - i))
        */
        int[] ple = new int[size];
        int[] nle = new int[size];
        Stack<Integer> stack = new Stack<>(); //index

        //calc PLE, start form left
        for (int i = 0; i < size; i++) {
            // use ">=" to deal with duplicate elements, in NLE the equal case will not be processed again
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            //Note: when in_stk_p is empty, which means there is no previous less element for A[i], in this case, we set left[i] = i+1 by default.
            //      because we are counting distance here, you can think of it default as i - (-1), while -1 should be the previous less element
            ple[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();

        //calc NLE, start from right
        for (int i = size - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            nle[i] = stack.isEmpty() ? size : stack.peek();
            stack.push(i);
        }

        long sum = 0;
        long mod = (long)1e9 + 7;
        for (int i = 0; i < size; i++) {
            sum += (long)(i - ple[i]) * arr[i] * (nle[i] - i);
        }
        return (int)(sum % mod);
    }
}
