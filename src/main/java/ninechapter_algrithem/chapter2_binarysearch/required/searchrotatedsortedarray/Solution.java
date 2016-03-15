package ninechapter_algrithem.chapter2_binarysearch.required.searchrotatedsortedarray;

/**
 * Author: blueaken
 * Date: 2/24/16 10:48 AM
 */
public class Solution {

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start < end){
            int mid = (start + end) / 2;
            if (nums[mid] == target){
                return mid;
            }

            if (nums[mid] < nums[end]){
                //right side is sorted
                if (nums[mid] < target && target <= nums[end]){
                    start = mid + 1;
                } else{
                    end = mid - 1;
                }
            } else{
                //left side is sorted
                if (nums[mid] > target && target >= nums[start]){
                    end = mid - 1;
                } else{
                    start = mid + 1;
                }
            }
        }

        return nums[start] == target ? start : -1;
    }

    public static void main(String[] args){
//        int[] nums = {6,-3,1,2,3,4,5};//left
//        int[] nums = {4,5,6,7,8,9,10,11,12,-2,1,2,3};//right
        int[] nums = {4,5,6,-2,1,2,3};//middle
//        int[] nums = {1,2,3};
        System.out.println("location of the target is: "  + search(nums, -2));
    }
}
