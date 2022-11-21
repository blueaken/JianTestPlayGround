package lintcode.binarysearch;

public class FindMinInRotatedSortedArray_158 {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    //Idea: 不断和nums[nums.length-1]比较，判断pivot在哪个区间
    public int findMin(int[] nums) {
        // write your code here
        if (nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) >> 1;
            if (nums[mid] > nums[nums.length-1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }
}
