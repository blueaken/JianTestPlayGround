package leetcode.algorithm.medium.twosum2;

import java.util.Arrays;

/**
 * Created by jshe18 on 8/6/15.
 */
public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        //assume nums is already sorted
        int i=0;
        int j= nums.length-1;
        while (i<j){
            int sum = nums[i] + nums[j];
            if (sum>target){
                j--;
            } else if(sum<target){
                i++;
            } else{
                int[] result = {i+1, j+1};
                return result;
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args){
        int[] nums = {2,7,11,13};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }
}
