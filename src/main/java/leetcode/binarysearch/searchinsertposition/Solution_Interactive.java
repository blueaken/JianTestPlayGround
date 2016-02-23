package leetcode.binarysearch.searchinsertposition;

/**
 * Author: blueaken
 * Date: 11/26/15 10:50 AM
 */
public class Solution_Interactive {
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<right){
            int mid = (left+right)/2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        return nums[left] < target ?  left+1 : left;
    }

    public static void main(String[] args){
        int[] test = {1,3};
        int target1 = 5;
        int target2 = 2;
        int target3 = 7;
        int target4 = 0;
        int target5 = 12;
        System.out.println(searchInsert(test, target1));
        System.out.println(searchInsert(test, target2));
        System.out.println(searchInsert(test, target3));
        System.out.println(searchInsert(test, target4));
        System.out.println(searchInsert(test, target5));
    }
}
