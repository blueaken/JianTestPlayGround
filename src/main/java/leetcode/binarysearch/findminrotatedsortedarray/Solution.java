package leetcode.binarysearch.findminrotatedsortedarray;

/**
 * Created by jshe18 on 8/1/15.
 */
public class Solution {
    public int findMin(int[] nums) {
        return rec(nums, 0, nums.length-1);
    }

    private int rec(int[] nums, int left, int right){
        //in case of not rotate
        if (nums[left]<nums[right]){
            return nums[left];
        }

        //rotate case
        int size = right-left+1;
        if (size==1){
            return nums[left];
        }
        if (size==2){
            return Math.min(nums[left], nums[right]);
        }

        int mid = (left+right)/2;
        int midVal = nums[mid];
        int midLeftVal = nums[mid-1];
        int midRightVal = nums[mid+1];

        if (midVal<midLeftVal && midVal<midRightVal){
            return midVal;
        }

        if (midVal<nums[left]){
            return rec(nums, left, mid-1);
        }

        if (midVal>nums[left]){
            return rec(nums, mid+1, right);
        }

        return Integer.MIN_VALUE; //not found
    }
}
