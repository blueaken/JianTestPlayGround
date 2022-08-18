package lintcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSmallerNumbersAfterSelf_LE_315 {
    /*
        - ref https://www.youtube.com/watch?v=B7vkfZcJNeY
        - divide & conqure then merge sort
        - similar to 1649, which is somehow harder
    */

    int[] smaller;

    public List<Integer> countSmaller(int[] nums) {

        int len = nums.length;
        smaller = new int[len];
        int[] sorted = Arrays.copyOfRange(nums, 0, len);

        helper(nums, sorted, 0, len - 1);

        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            ret.add(smaller[i]);
        }
        return ret;
    }

    private void helper(int[] nums, int[] sorted, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        helper(nums, sorted, start, mid);
        helper(nums, sorted, mid+1, end);

        //adjust for the left half
        for (int i = start; i <= mid; i++) {
            int lowerBound = binarySearch(sorted, mid+1, end, nums[i]);
            smaller[i] += lowerBound - (mid+1);
        }

        Arrays.sort(sorted, start, end+1);
    }

    private int binarySearch(int[] sorted, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (sorted[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        // If target is greater than last element which is sorted[start] then lower bound does not exists in the array
        if (sorted[start] < target) {
            start++;
        }

        return start;
    }

    public static void main(String[] args) {
        CountSmallerNumbersAfterSelf_LE_315 solution = new CountSmallerNumbersAfterSelf_LE_315();
        int[] nums = {5,2,6,1};//[2, 1, 1, 0]
        System.out.println(solution.countSmaller(nums));
    }
}
