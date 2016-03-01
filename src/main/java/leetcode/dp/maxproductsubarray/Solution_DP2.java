package leetcode.dp.maxproductsubarray;

/**
 * Created by jshe18 on 7/19/15.
 */
public class Solution_DP2 {
    public int maxProduct(int[] nums) {
        int max_temp=nums[0];
        int min_temp=nums[0];

        int max_final=nums[0];

        int max_current, min_current;
        for (int i=1; i<nums.length; i++){
            max_current = max_temp * nums[i];
            min_current = min_temp * nums[i];

            max_temp = Math.max(Math.max(max_current, min_current), nums[i]);
            min_temp = Math.min(Math.min(max_current, min_current), nums[i]);
            max_final = Math.max(max_temp, max_final);
        }
        return max_final;
    }
}
