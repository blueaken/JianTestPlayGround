package lintcode.divideconquer;

import java.util.Arrays;

public class CreateSortedArrayThroughInstructions_LE_1649_P1 {
    /*
        read Huifeng Guan video - https://www.youtube.com/watch?v=B7vkfZcJNeY
        - the trick is 315 solution + how to implement C++ lower_bound method in Java
        - count the smaller numbers before each position first
    */
    public int createSortedArray(int[] instructions) {
        int n = instructions.length;
        int[] smaller = new int[n];
        int[] sorted = Arrays.copyOfRange(instructions, 0, n);

        helper(instructions, sorted, 0, n-1, smaller);

        int[] count = new int[100001]; //count current number
        int mod = (int)1e9+7;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cost = Math.min(smaller[i], i - count[instructions[i]] - smaller[i]);
            count[instructions[i]]++;
            ans = (ans + cost) % mod;
        }
        return ans;
    }

    private void helper(int[] nums, int[] sorted, int start, int end, int[] smaller) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        helper(nums, sorted, start, mid, smaller);
        helper(nums, sorted, mid+1, end, smaller);

        //adjust the right half
        for (int i = mid+1; i <= end; i++) {
            int lb = bs(sorted, start, mid, nums[i]);
            smaller[i] += lb - start;
        }

        Arrays.sort(sorted, start, end+1);
    }

    private int bs(int[] sorted, int start, int end, int val) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (sorted[mid] >= val) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        //if not found return upper bound
        if (sorted[start] < val) {
            start++;
        }

        return start;
    }
}
