package lintcode.dynamicprogramming2.maxsubarray;

public class MaximumSubarray_LE_53_Divide_And_Conquer {
    /*
        - ref https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-53-maximum-subarray/
        - Space can optimize to O(1)
        - Redo with Divide & Conquer, ref https://www.youtube.com/watch?v=gEHBSWdHgGg
        - Time is O(NLogN), analysis ref above link
    */
    public int maxSubArray(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        return helper(nums, start, end);
    }

    int helper(int[] nums, int start, int end) {
        //boundray
        if (start == end) {
            return nums[start];
        }
        if (start > end) {
            //overflow
            return Integer.MIN_VALUE;
        }

        //find
        int mid = start + (end - start) / 2;
        int left = helper(nums, start, mid - 1);
        int right = helper(nums, mid + 1, end);

        //mid element case
        int ml = 0, mr = 0;
        for (int i = mid - 1, sum = 0; i >= start; i--) {
            sum += nums[i];
            ml = Math.max(ml, sum);
        }
        for (int i = mid + 1, sum = 0; i <= end; i++) {
            sum += nums[i];
            mr = Math.max(mr, sum);
        }
        int mid_max = ml + nums[mid] + mr;

        //return the max of above 3 cases
        return (Math.max(Math.max(left, right), mid_max));

    }
}
