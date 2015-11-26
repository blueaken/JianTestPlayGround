package leetcode.medium.searchinsertposition;

/**
 * Author: blueaken
 * Date: 11/25/15 9:42 PM
 */
public class Solution {
    public static int searchInsert(int[] nums, int target) {
        return rec(nums, 0, nums.length-1, target);
    }

    static int rec(int[] data, int left, int right, int val){
        if (left == right) {
            if (data[left] < val) {
                return left+1;
            }
            if (data[left] > val){
                return left;
            }
        }

        if (left > right) return left;

        int mid = (left+right)/2;
        if (data[mid] == val) return mid;
        else if (data[mid] < val) return rec(data, mid + 1, right, val);
        else return rec(data, left, mid-1, val);
    }

    public static void main(String[] args){
        int[] test = {1,3,5,10};
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

        int[] test1 = {1,3};
        int target11 = 0;
        System.out.println(searchInsert(test1, target11));
    }
}
