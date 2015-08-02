package leetcode.hard.findminrotatedsortedarray_duplicate_value;

/**
 * Created by jshe18 on 8/1/15.
 */
public class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int mid;
        while (left<right && nums[left]>=nums[right]){
            mid = (left+right)/2;
            if (nums[mid]>nums[right]){
                left = mid+1;
            }else if (nums[mid]<nums[right]){
                right = mid;
            }else {//equal case
                right--;
            }
        }
        return nums[left];
    }
}
