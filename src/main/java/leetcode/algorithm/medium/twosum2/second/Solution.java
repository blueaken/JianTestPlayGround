package leetcode.algorithm.medium.twosum2.second;

import java.util.Arrays;

/**
 * Author: blueaken
 * Date: 12/9/15 8:15 PM
 */
public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int i = 0 ;
        int j = nums.length-1;
        while (i<j){
            int sum = nums[i] + nums[j];
            if (sum == target){
                return new int[] {i+1, j+1};
            } else if (sum > target){
                j--;
            } else {
                i++;
            }
        }
        return new int[2];
    }

    public static void main(String[] args){
        int[] numbers = {2, 7, 11, 15};
        int target=9;

        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }
}
