package lintcode.others.count_subarray_by_element;

import java.util.ArrayDeque;
import java.util.Deque;

public class SubArrayRanges_LE_2104_P2 {
    /*
        P2
        - count subarray by element type
        - idea is for each element calc the its contribute as max and as min, then subtract; so as to achieve O(N)
    */
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long[] ple = new long[n];
        long[] nle = new long[n];

        long[] pge = new long[n];
        long[] nge = new long[n];

        Deque<Integer> stack_less = new ArrayDeque<>();
        Deque<Integer> stack_greater = new ArrayDeque<>();

        //ple & pge
        for (int i = 0; i < n; i++) {
            while (!stack_less.isEmpty() && nums[stack_less.peekLast()] >= nums[i]) {
                stack_less.removeLast();
            }
            ple[i] = stack_less.isEmpty() ? i + 1 : i - stack_less.peekLast();
            stack_less.addLast(i);

            while (!stack_greater.isEmpty() && nums[stack_greater.peekLast()] <= nums[i]) {
                stack_greater.removeLast();
            }
            pge[i] = stack_greater.isEmpty() ? i + 1 : i - stack_greater.peekLast();
            stack_greater.addLast(i);
        }
        stack_less.clear();
        stack_greater.clear();

        //nle & nge
        for (int i = n - 1; i >= 0; i--) {
            while (!stack_less.isEmpty() && nums[stack_less.peekLast()] > nums[i]) {
                stack_less.removeLast();
            }
            nle[i] = stack_less.isEmpty() ? n - i : stack_less.peekLast() - i;
            stack_less.addLast(i);

            while (!stack_greater.isEmpty() && nums[stack_greater.peekLast()] < nums[i]) {
                stack_greater.removeLast();
            }
            nge[i] = stack_greater.isEmpty() ? n - i : stack_greater.peekLast() - i;
            stack_greater.addLast(i);
        }

        //put it together
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += nums[i] * (pge[i] * nge[i] - ple[i] * nle[i]);
        }
        return ans;
    }
}
