package lintcode.binarysearch.labuladong.variant;

public class SearchRotatedSortedArray_LE_33_P1 {
    /*
        - many different ways to attack this, the key is the positioin between mid and left
        - refactor previous solution following an easier to understand version -  https://leetcode.com/problems/search-in-rotated-sorted-array/solution/
        ===========================
        P1 12.12.2022
        redo after read 东哥 post
    */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[left]) {
                //left half is sorted
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                //right hald if sorted
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
