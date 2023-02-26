package lintcode.mergesort;

public class CountOfRangeSum_LE_327_MergeSort {
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
       ===========================================
       11.09.2022
       ref labuladong post
       solve with merge sort
    */

    int count = 0;
    long lower = 0;
    long upper = 0;

    long[] temp;
    public int countRangeSum(int[] nums, int lower, int upper) {
        this.lower = lower;
        this.upper = upper;

        int n = nums.length;
        long[] ps = new long[n+1];
        for (int i = 0; i < n; i++) {
            ps[i+1] = nums[i] + ps[i];
        }

        temp = new long[n+1];

        sort(ps, 0, n);
        return count;
    }

    private void sort(long[] arr, int lo, int hi) {
        if (lo == hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;

        sort(arr, lo, mid);
        sort(arr, mid+1, hi);

        merge(arr, lo, mid, hi);
    }

    private void merge(long[] arr, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            temp[i] = arr[i];
        }

        //合并2个有序子数组前，先数一下range sum, note维护一个左闭右开区间[start, end)，具体见东哥post
        int start = mid+1, end = mid+1;
        for (int i = lo; i <= mid; i++) {
            while (start <= hi && arr[start] - arr[i] < lower) {
                start++;
            }
            while (end <= hi && arr[end] - arr[i] <= upper) {
                end++;
            }

            count += end - start;
        }

        int i = lo, j = mid+1;
        for (int pos = lo; pos <= hi; pos++) {
            if (i == mid+1) {
                arr[pos] = temp[j++];
            } else if (j == hi+1) {
                arr[pos] = temp[i++];
            } else if (temp[i] < temp[j]) {
                arr[pos] = temp[i++];
            } else {
                arr[pos] = temp[j++];
            }
        }
    }
}
