package leetcode.medium.searchrotatedsortedarray;

/**
 * Created by jshe18 on 8/1/15.
 */
public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        int mid;
        while(left<=right){
            mid = (left+right)/2;
            if (nums[mid] == target){
                return mid;
            }

            if (nums[mid] < nums[right]){
                //right side is sorted
                if (target <= nums[right] && target > nums[mid]){
                    left = mid+1;
                }
                else {
                    right = mid-1;
                }
            }else{
                //left side is sorted
                if (target < nums[mid] && target >= nums[left]){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }
        }

        return -1; //not found
    }
}
