package lintcode.mergesort;

public class ReversePairs_LE_493_MergeSort {
    /*
        read Huifeng Guan post
        - to any fix postion j, find how many previous pos i, its value nums[i] is larger than nums[j] * 2
        - Divide & Conquer type
        - similar to 315 and 1649
        - Time - N (iterate each pos) * LogN (outside recursive call) * LogN (additional adjust for each position of right half - binary search) ~ O(NLogNLogN)
        - 尝试了不同的Java实现upper_bound方式，最后还是通过2分法实现了。(Java本身的Arrays.binarySearch()会TLE)
        ========================
        11.09.2022
        ref labuladong post
        solve it with merge sort
        ========================
        02.26.2023
        redo with 东哥 merge sort template
    */

    int[] temp;
    int count = 0;
    public int reversePairs(int[] nums) {
        int n = nums.length;
        temp = new int[n];

        sort(nums, 0, n-1);
        return count;
    }

    private void sort(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(nums, lo, mid);
        sort(nums, mid+1, hi);

        merge(nums, lo, mid, hi);
    }

    private void merge(int[] nums, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            temp[i] = nums[i];
        }

        int end = mid+1;
        for (int i = lo; i <= mid; i++) {
            while (end <= hi && ((long)nums[i] > (long)2 * nums[end])) {
                end++;
            }
            count += end - (mid+1);
        }

        int i = lo, j = mid+1;
        for (int p = lo; p <= hi; p++) {
            if (i == mid+1) {
                nums[p] = temp[j++];
            } else if (j == hi + 1) {
                nums[p] = temp[i++];
            } else if (temp[i] > temp[j]) {
                nums[p] = temp[j++];
            } else {
                nums[p] = temp[i++];
            }
        }
    }
}
