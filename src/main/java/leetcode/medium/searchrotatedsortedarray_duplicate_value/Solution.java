package leetcode.medium.searchrotatedsortedarray_duplicate_value;

/**
 * Created by jshe18 on 8/2/15.
 */
public class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        int mid;
        while(left<=right){
            mid = (left+right)/2;
            if (nums[mid] == target){
                return true;
            }

            if (nums[mid] < nums[right]){
                //right side is sorted
                if (target <= nums[right] && target > nums[mid]){
                    left = mid+1;
                }
                else {
                    right = mid-1;
                }
            }else if (nums[mid] > nums[right]){
                //left side is sorted
                if (target < nums[mid] && target >= nums[left]){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }else {//nums[mid] == nums[right], skip duplicates
                right --;
            }
        }

        return false;
    }
}
