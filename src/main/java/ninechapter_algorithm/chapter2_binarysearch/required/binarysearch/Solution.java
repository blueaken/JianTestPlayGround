package ninechapter_algorithm.chapter2_binarysearch.required.binarysearch;

/**
 * Author: blueaken
 * Date: 2/23/16 11:26 AM
 */
public class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public static int binarySearch(int[] nums, int target) {
        //write your code here
        if (nums == null || nums.length == 0){
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start < end){
            int mid = (start + end) / 2;
            if(nums[mid] < target){
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        if (nums[start] == target){
            return findTheSmallestIndex(nums, start);
        }

        return -1;
    }

    private static int findTheSmallestIndex(int[]nums, int index){
        while (index > 0 && nums[index] == nums[index-1]) {
            index--;
        }
        return index;
    }

    public static void main(String[] args){
//        int[] test = {1, 2, 3, 3, 4, 5, 5, 5, 5, 10};
//        int target = 1;

        int[] test = {2,6,8,13,15,17,17,18,19,20};
        int target = 15;

        System.out.println(binarySearch(test, target));
    }
}
