package lintcode.others.count_subarray_by_element;

import java.util.Stack;

public class SubArrayRanges_LE_2104_P3 {
    /*
        P2
        - count subarray by element type
        - idea is for each element calc the its contribute as max and as min, then subtract; so as to achieve O(N)
        ===============
        P3 10.10.2022
    */
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long[]ple = new long[n];
        long[]nle = new long[n];

        long[]pge = new long[n];
        long[]nge = new long[n];

        Stack<Integer> stk_less = new Stack<>();
        Stack<Integer> stk_greater = new Stack<>();
        for (int i = 0; i < n; i++) {
            //ple - mono increasing stack
            while (stk_less.size() > 0 && nums[i] < nums[stk_less.peek()]) {
                stk_less.pop();
            }
            ple[i] = stk_less.size() == 0 ? i + 1 : i - stk_less.peek();
            stk_less.push(i);

            //pge - mono decreasing stack
            while (stk_greater.size() > 0 && nums[i] > nums[stk_greater.peek()]) {
                stk_greater.pop();
            }
            pge[i] = stk_greater.size() == 0 ? i + 1 : i - stk_greater.peek();
            stk_greater.push(i);
        }
        stk_less.clear();
        stk_greater.clear();

        for (int i = n - 1; i >= 0; i--) {
            //nle - mono decreasing stack
            while (stk_less.size() > 0 && nums[i] <= nums[stk_less.peek()]) {
                stk_less.pop();
            }
            nle[i] = stk_less.size() == 0 ? n - i : stk_less.peek() - i;
            stk_less.push(i);

            //nge - mono increasing stack
            while (stk_greater.size() > 0 && nums[i] >= nums[stk_greater.peek()]) {
                stk_greater.pop();
            }
            nge[i] = stk_greater.size() == 0 ? n - i : stk_greater.peek() - i;
            stk_greater.push(i);
        }

        long sumMax = 0;
        long sumMin = 0;
        for (int i = 0; i < n; i++) {
            sumMax += nums[i] * (pge[i] * nge[i]);
            sumMin += nums[i] * (ple[i] * nle[i]);
        }
        return sumMax - sumMin;
    }
}
