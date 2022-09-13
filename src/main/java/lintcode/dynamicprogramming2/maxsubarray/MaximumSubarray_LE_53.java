package lintcode.dynamicprogramming2.maxsubarray;

public class MaximumSubarray_LE_53 {
    /*
        - ref https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-53-maximum-subarray/
        - Space can optimize to O(1)
    */
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
