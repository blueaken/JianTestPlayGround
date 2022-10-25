package lintcode.dynamicprogramming2;

public class HouseRobber2_LE_213 {
    /*
        10.25.2022
        ref labaladong post
        - 和198不同之处在于首尾房子不能同时选择，那么就比较选择第一个房子和选择最后一个房子之间的最大值即可
    */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        return Math.max(robInRange(nums, 0, n-2), robInRange(nums, 1, n-1));
    }

    private int robInRange(int[] nums, int start, int end) {
        int dp_i = 0;
        int dp_i_1 = 0, dp_i_2 = 0;
        for (int i = start; i <= end; i++) {
            dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
            dp_i_2 = dp_i_1;//in next iteration, dp_i_2 is current dp_i_1
            dp_i_1 = dp_i; //in next iteration, dp_i_1 is current dp_i
        }

        return dp_i;
    }
}
