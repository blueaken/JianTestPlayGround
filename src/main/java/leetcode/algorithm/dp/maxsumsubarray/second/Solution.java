package leetcode.algorithm.dp.maxsumsubarray.second;

/**
 * Created by jshe18 on 11/19/15.
 */
public class Solution {
    public static int maxSubArray(int[] nums) {
        return rec(nums, 0, nums.length-1);
    }

    static int rec(int[]nums, int left, int right){
        if (left>right) return Integer.MIN_VALUE;
        int mid = (left+right)/2;
        int leftMax = rec(nums, 0, mid-1);
        int rightMax = rec(nums, mid+1, right);

        int sum = 0;
        int leftSumMax = 0;
        for (int i=mid-1; i>=0; i--){
            sum += nums[i];
            leftSumMax = Math.max(sum, leftSumMax);
        }

        sum = 0;
        int rightSumMax = 0;
        for (int i=mid+1; i<right; i++){
            sum += nums[i];
            rightSumMax = Math.max(sum, rightSumMax);
        }

        return Math.max(leftSumMax + nums[mid] + rightSumMax, Math.max(leftMax, rightMax));
    }

    public static void main(String[] args){
        int[] test = {-2,1,-3,4,-1,2,1,-5,4};
        int[] test1 = {-1};

        System.out.println("The max sum subarray of the test is: " + maxSubArray(test));
//        System.out.println("The max sum subarray of the test is: " + maxSubArray(test1));
    }
}
