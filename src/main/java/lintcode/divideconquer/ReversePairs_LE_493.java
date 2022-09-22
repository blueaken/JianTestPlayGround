package lintcode.divideconquer;

import java.util.Arrays;

public class ReversePairs_LE_493 {
    /*
        read Huifeng Guan post
        - to any fix postion j, find how many previous pos i, its value nums[i] is larger than nums[j] * 2
        - Divide & Conquer type
        - similar to 315 and 1649
        - Time - N (iterate each pos) * LogN (outside recursive call) * LogN (additional adjust for each position of right half - binary search) ~ O(NLogNLogN)
        - 尝试了不同的Java实现upper_bound方式，最后还是通过2分法实现了。(Java本身的Arrays.binarySearch()会TLE)
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
            // int ub = upper_bound(sorted, start, mid, 2 * (long)nums[i]);
            int ub = upper_bound_bs(sorted, start, mid, 2 * (long)nums[i]);

            ans += (mid + 1) - ub;
        }

        Arrays.sort(sorted, start, end+1);
    }

    //二分查找数组中等于key的位置，找到返回该数字的最大地址+1，当Key大于数组范围或者等于最后一个元素时，返回最大地址+1
    public int upper_bound_bs(long arr[], int low, int high, long key) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        //当Key大于数组范围或者等于最后一个元素时，返回最大地址+1
        if (arr[low] <= key) {
            low++;
        }

        return low;
    }

//     //Using build in Arrays.binarySearch()
//     public int upper_bound(long arr[], int start, int end, long val){

//         int diff = start;

//         long[] temp = Arrays.copyOfRange(arr, start, end+1);

//         int index = Arrays.binarySearch(temp, val);

//         if (index < 0) {//val not in arr, java bs returned "-insertion point", and the insertion point is 1-indexed; need to convert it to 0 based index
//             index = Math.abs(index) - 1;
//         } else { //val in arr, return the index of the 1st element greater then val
//             while (index < temp.length && temp[index] == val) {
//                 index++;
//             }
//         }
//         return index + diff;
//     }
}
