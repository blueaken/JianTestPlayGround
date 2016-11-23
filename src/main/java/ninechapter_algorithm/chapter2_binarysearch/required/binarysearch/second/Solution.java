package ninechapter_algorithm.chapter2_binarysearch.required.binarysearch.second;

/**
 * Author: blueaken
 * Date: 4/12/16 10:25 AM
 */
public class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return nums[start] == target ? start : -1;
    }
}
