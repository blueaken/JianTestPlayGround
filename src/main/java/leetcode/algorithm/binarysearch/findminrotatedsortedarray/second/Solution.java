package leetcode.algorithm.binarysearch.findminrotatedsortedarray.second;

/**
 * Author: blueaken
 * Date: 11/29/15 9:23 AM
 */
public class Solution {
    public static int findMin(int[] nums) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length-1;
        while (left<right && nums[left]>nums[right]){
            int mid = (left+right)/2;
            if (nums[mid]>nums[right]) {
                left = mid + 1;
            } else{
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args){
        int[] nums = {6,-3,1,2,3,4,5};//left
//        int[] nums = {4,5,6,7,8,9,10,11,12,-2,1,2,3};//right
//        int[] nums = {4,5,6,-2,1,2,3};//middle
//        int[] nums = {1,2,3};

        System.out.println("min value from the rotated array is: "  + findMin(nums));
    }
}
