package leetcode.dp.maxsumsubarray.second;

/**
 * Author: blueaken
 * Date: 11/21/15 8:26 AM
 */
public class Solution_DP {
    public static int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int temp = 0;
        for (int i=0; i<nums.length; i++){
            temp = Math.max(temp+nums[i], nums[i]);
            max = Math.max(temp, max);
        }

        return max;
    }

    public static void main(String[] args){
        int[] test = {-2,1,-3,4,-1,2,1,-5,4};
        int[] test1 = {-1};

        System.out.println("The max sum subarray of the test is: " + maxSubArray(test));
        System.out.println("The max sum subarray of the test is: " + maxSubArray(test1));
    }
}
