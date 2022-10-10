package lintcode.others.count_subarray_by_element;

import java.util.Stack;

public class SumSubarrayMins_LE_907_MonoStack_P3 {
    /*
        P2
        ref previous notes
        Idea:
        1. use the lps dp template to found the list of sub arrays, then sum the mins
        Time - O(N^3) + O(N), simplified to O(N^3), Space - O(N^2).

        2. with Monotonic Stack, to any element A[i], found the position of PLE and NLE, then the number of subarray between is m*n, m - the distance to PLE, n - the distance to NLE. For each subarray, the min is A[i]. A[i]*m*n is the A[i] part contribute to the answer.
        Ref - https://leetcode.com/problems/sum-of-subarray-minimums/discuss/178876/stack-solution-with-very-detailed-explanation-step-by-step
        Time - O(N + N + N), simplified to O(N), Space - O(N)
       =====================================
       P3
       - 10.10.2022
       - ref previous notes
    */
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();//index
        int[] ple = new int[n];
        for (int i = 0; i < n; i++) {
            //monotonic increasing stack, note: equal relationship need handled either in ple or nle
            while (stack.size() > 0 && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            ple[i] = stack.size() == 0 ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        stack.clear();

        int[] nle = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            //monotonic decreasing stack
            while (stack.size() > 0 && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            nle[i] = stack.size() == 0 ? n - i : stack.peek() - i;
            stack.push(i);
        }

        long ans = 0;
        long mod = (long)1e9 + 7;
        for (int i = 0; i < n; i++) {
            ans += (long)ple[i] * nle[i] * arr[i];
        }
        return (int)(ans % mod);
    }
}
