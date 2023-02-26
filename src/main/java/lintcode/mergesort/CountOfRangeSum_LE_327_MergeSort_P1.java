package lintcode.mergesort;

public class CountOfRangeSum_LE_327_MergeSort_P1 {
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
       ====================================
       02.26.2023
       redo with 东哥 merge sort 模板
    */

    long lower, upper;
    long[] temp;
    int count = 0;
    public int countRangeSum(int[] nums, int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
        int n = nums.length;
        long[] ps = new long[n+1];
        for (int i = 1; i <= n; i++) {
            ps[i] = ps[i-1] + nums[i-1];
        }

        sort(ps);
        return count;
    }

    private void sort(long[] ps) {
        int n = ps.length;
        temp = new long[n];
        sort(ps, 0, n-1);
    }

    private void sort(long[] ps, int lo, int hi) {
        if (lo == hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(ps, lo, mid);
        sort(ps, mid+1, hi);

        merge(ps, lo, mid, hi);
    }

    private void merge(long[] ps, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            temp[i] = ps[i];
        }

        // 进行效率优化
        // 维护左闭右开区间 [start, end) 中的元素和 nums[i] 的差在 [lower, upper] 中
        int start = mid+1, end = mid+1;
        for (int i = lo; i <= mid; i++) {
            while (start <= hi && ps[start] - ps[i] < this.lower) {
                start++;
            }
            while (end <= hi && ps[end] - ps[i] <= this.upper) {
                end++;
            }
            count += end - start;
        }

        int i = lo, j = mid+1;
        for (int p = lo; p <= hi; p++) {
            if (i == mid+1) {
                ps[p] = temp[j++];
            } else if (j == hi+1) {
                ps[p] = temp[i++];
            } else if (temp[i] > temp[j]) {
                ps[p] = temp[j++];
            } else {
                ps[p] = temp[i++];
            }
        }

    }

}
