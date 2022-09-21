package lintcode.divideconquer;

import java.util.Arrays;

public class ReversePairs_LE_493 {
    /*
        read Huifeng Guan post
        - to any fix postion j, find how many previous pos i, its value nums[i] is larger than nums[j] * 2
        - Divide & Conquer type
        - similar to 315 and 1649
        - Time - N (iterate each pos) * LogN (outside recursive call) * LogN (additional adjust for each position of right half - binary search) ~ O(NLogNLogN)
        - still got TLE, but I think that is it so far, already made enough breaks now.
    */

    int ans = 0;
    public int reversePairs(int[] nums) {
        int n = nums.length;
        long[] sorted = new long[n]; //convert sorted to long in case integer overflow
        for (int i = 0; i < n; i++) {
            sorted[i] = (long)nums[i];
        }

        helper(nums, sorted, 0, n-1);

        return ans;
    }

    private void helper(int[] nums, long[] sorted, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        helper(nums, sorted, start, mid);
        helper(nums, sorted, mid+1, end);

        //adjust right half
        for (int i = mid+1; i <= end; i++) {
            int ub = upper_bound(sorted, start, mid, 2 * (long)nums[i]);
            ans += (mid + 1) - ub;
        }

        Arrays.sort(sorted, start, end+1);
    }

    //Using build in Arrays.binarySearch()
    public int upper_bound(long arr[], int start, int end, long val){

        int diff = start;

        long[] temp = Arrays.copyOfRange(arr, start, end+1);

        int index = Arrays.binarySearch(temp, val);

        if (index < 0) {//val not in arr, java bs returned "-insertion point", and the insertion point is 1-indexed; need to convert it to 0 based index
            index = Math.abs(index) - 1;
        } else { //val in arr, return the index of the 1st element greater then val
            while (index < temp.length && temp[index] == val) {
                index++;
            }
        }
        return index + diff;
    }
}
