package leetcode.medium.maxsumsubarray;

/**
 * Created by jshe18 on 7/15/15.
 */
public class Solution_DP {
    public int maxSubArray(int[] nums) {
        int max_current=nums[0];
        int max_final=nums[0];

        for (int i=1; i<nums.length; i++){
            max_current = Math.max((max_current + nums[i]), nums[i]);
            max_final = Math.max(max_current, max_final);
        }
        return max_final;
    }
}
