package lintcode.others.count_subarray_by_element;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumSubarrayMins_LE_907_MonoStack_P2 {
    /*
        P2
        ref previous notes
        Idea:
        1. use the lps dp template to found the list of sub arrays, then sum the mins
        Time - O(N^3) + O(N), simplified to O(N^3), Space - O(N^2).

        2. with Monotonic Stack, to any element A[i], found the position of PLE and NLE, then the number of subarray between is m*n, m - the distance to PLE, n - the distance to NLE. For each subarray, the min is A[i]. A[i]*m*n is the A[i] part contribute to the answer.
        Ref - https://leetcode.com/problems/sum-of-subarray-minimums/discuss/178876/stack-solution-with-very-detailed-explanation-step-by-step
        Time - O(N + N + N), simplified to O(N), Space - O(N)

    */
    public int sumSubarrayMins(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        //ple
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peekLast()] >= arr[i]) {
                stack.removeLast();
            }
            left[i] = stack.isEmpty() ? i + 1 : i - stack.peekLast();
            stack.addLast(i);
        }
        stack.clear();

        //nle
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peekLast()] > arr[i]) {
                stack.removeLast();
            }
            right[i] = stack.isEmpty() ? n - i : stack.peekLast() - i;
            stack.addLast(i);
        }

        long sum = 0;
        long mod = (long)1e9 + 7;
        for (int i = 0; i < n; i++) {
            sum += (long)left[i] * arr[i] * right[i];
        }
        return (int)(sum % mod);
    }
}
