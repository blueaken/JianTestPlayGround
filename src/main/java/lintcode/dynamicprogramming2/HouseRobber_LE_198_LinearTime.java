package lintcode.dynamicprogramming2;

public class HouseRobber_LE_198_LinearTime {
    /*
        10.25.2022
        ref labaladong post
        - solve with top down DP with mem cache
        - refactor DP to O(N) Time
    */
    public int rob(int[] nums) {

        return dp(nums); //arr
    }

    private int dp(int[] nums) {

        int dp_i = 0;
        int dp_i_1 = 0, dp_i_2 = 0;
        for (int i = 0; i < nums.length; i++) {
            dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
            dp_i_2 = dp_i_1;//in next iteration, dp_i_2 is current dp_i_1
            dp_i_1 = dp_i; //in next iteration, dp_i_1 is current dp_i
        }

        return dp_i;
    }
}
