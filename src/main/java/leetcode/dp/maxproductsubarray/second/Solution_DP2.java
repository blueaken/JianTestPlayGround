package leetcode.dp.maxproductsubarray.second;

/**
 * Author: blueaken
 * Date: 11/21/15 9:35 AM
 */
public class Solution_DP2 {
    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int tempMax = 1;
        int tempMin = 1;
        int currentMax = 1;
        int currentMin = 1;
        for (int i=0; i<nums.length; i++){
            currentMax = tempMax*nums[i];
            currentMin = tempMin*nums[i];

            tempMax = Math.max(Math.max(currentMax, currentMin), nums[i]);
            tempMin = Math.min(Math.min(currentMax, currentMin), nums[i]);

            max = Math.max(tempMax, max);
        }

        return max;
    }

    public static void main(String[] args){
        int[] test = {2,3,-2,-4,-4};
        int[] test1 = {-1};
        int[] test2 = {0,2};
        int[] test3 = {-1,-2,-9,-6};

        System.out.println("The max product subarray of the test is: " + maxProduct(test));
        System.out.println("The max product subarray of the test is: " + maxProduct(test1));
        System.out.println("The max product subarray of the test is: " + maxProduct(test2));
        System.out.println("The max product subarray of the test is: " + maxProduct(test3));
    }
}
