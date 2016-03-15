package ninechapter_algrithem.chapter2_binarysearch.required.findminimumrotatedsortedarray;

/**
 * Author: blueaken
 * Date: 2/23/16 9:46 PM
 */
public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public static int findMin(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0){
            return -1;
        }

        int start =0;
        int end = nums.length - 1;
        while (start < end && nums[start] >= nums[end]){
            int mid = (start + end) / 2;
            if (nums[mid] > nums[end]){
                start = mid + 1;
            } else{
                end = mid;
            }
        }

        return nums[start];
    }

    public static void main(String[] args){
        int[] test = {4,5,6,7,0,1,2};

        System.out.println(findMin(test));
    }
}
