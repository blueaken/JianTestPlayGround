package leetcode.binarysearch.findminrotatedsortedarray;

/**
 * Created by jshe18 on 8/1/15.
 */
public class Solution_WhileLoop {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int mid;
        while (left<right && nums[left]>nums[right]){
            mid = (left+right)/2;
            if (nums[mid]>nums[right]){
                left = mid+1;
            }
            if (nums[mid]<nums[right]){
                right = mid;
            }
        }
        return nums[left];
    }
}
