package leetcode.dp.maxsumsubarray;

/**
 * Created by jshe18 on 7/14/15.
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int max_current=0;
        int max_final=Integer.MIN_VALUE;

        for (int i=0; i<nums.length; i++){
            max_current += nums[i];
            max_final = Math.max(max_current, max_final);

            if (max_current<0){
                max_current = 0;
            }
        }
        return max_final;
    }
}
