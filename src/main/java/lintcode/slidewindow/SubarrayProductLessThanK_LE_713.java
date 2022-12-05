package lintcode.slidewindow;

public class SubarrayProductLessThanK_LE_713 {
    /**
     12.05.2022
     solve by 东哥 slide window template, since all values are positive
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int left = 0, right = 0;
        int product = 1;
        while (right < nums.length) {
            int r = nums[right];
            product *= r;
            right++;

            while (left < right && product >= k) {
                int l = nums[left];
                product /= l;
                left++;
            }

            //note - we get a valid subarray [left, right) now, the question is how many subarraies in this range? since the right position can only be visited here, we count every subarray ends in the right: ex, left = 1, right = 4,the current range is [1, 2, 3], the subarraies end at right is - [1,2,3], [2,3], [3], whose count is "right - left"
            count += right - left;
        }
        return count;
    }
}
