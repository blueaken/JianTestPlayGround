package leetcode.algorithm.binarysearch.findminrotatedsortedarray_duplicate_value.second;

/**
 * Author: blueaken
 * Date: 11/29/15 10:19 AM
 */
public class Solution {
    public static int findMin(int[] nums) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length-1;
        while (left<right && nums[left]>=nums[right]){
            int mid = (left+right)/2;
            if (nums[mid]>nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]){
                right = mid;
            } else{
                right--;
            }
        }

        return nums[left];
    }

    public static void main(String[] args){
//        int[] nums = {1,1,3,1};
//        int[] nums = {3,1,1};
        int[] nums = {3,1,3};
        System.out.println("min value from the rotated array is: "  + findMin(nums));
    }
}
