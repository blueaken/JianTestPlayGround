package lintcode.divideconquer;

import java.util.Arrays;

public class CountOfRangeSum_LE_327 {
    /*
        ref https://www.youtube.com/watch?v=m9P1drvDjzY
        Divide & Conquer type
        - similar to 315, 1649, 493
        Time also O(NLogNLogN)
        ==========================================================
        sum[i : j]
        lower <= presum[j] - presum[i-1] <= upper
        =>
        1. presum[j] >= presum[i-1] + lower => count of larger numbers after self
        2. presum[j] <= presum[i-1] + upper => count of smaller numbers after self

        presum need be 1-based so as to cover situation like the subarrays of front 4 elements: ps[4] - ps[0], the above formula need adjust accordingly
        nums:     [X X X X] X X X X
        presum: 0 Z Z Z Z Z Z Z Z


        A: [X X X X X X  ||  X X X X X X]
                i                 j

        B: [X X X X X X] C:  [X X X X X X]
            a   i     mid  mid+1        b
    */

    int ret = 0;
    long lower = 0;
    long upper = 0;
    public int countRangeSum(int[] nums, int lower, int upper) {
        this.lower = lower;
        this.upper = upper;

        int n = nums.length;
        long[] ps = new long[n+1];
        for (int i = 0; i < n; i++) {
            ps[i+1] = ps[i] + nums[i];
        }

        helper(ps, 0, n);
        return ret;
    }

    private void helper(long[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        helper(arr, start, mid);
        helper(arr, mid+1, end);

        for (int i = start; i <= mid; i++) {
            int x = lowerBound(arr, mid+1, end, arr[i] + lower);
            int y = upperBound(arr, mid+1, end, arr[i] + upper);
            ret += y - x;
        }

        Arrays.sort(arr, start, end+1);
    }

    //二分查找数组中等于key的位置，找到返回该数字的最小地址，不存在则return the insert position
    private int lowerBound(long[] arr, int start, int end, long val) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= val) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        if (arr[start] < val) {
            start++;
        }
        return start;
    }

    //二分查找数组中等于key的位置，找到返回该数字的最大地址+1，当Key大于数组范围或者等于最后一个元素时，返回最大地址+1
    private int upperBound(long[] arr, int start, int end, long val) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] <= val) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        if (arr[start] <= val) {
            start++;
        }
        return start;
    }
}
