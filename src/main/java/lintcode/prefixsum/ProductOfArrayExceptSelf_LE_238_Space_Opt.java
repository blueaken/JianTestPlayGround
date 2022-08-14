package lintcode.prefixsum;

public class ProductOfArrayExceptSelf_LE_238_Space_Opt {
    /*
        - https://www.youtube.com/watch?v=rpQhKorJRd8
        - Time O(N), Loop 2 times, Space O(1), no extra space other than the output array
    */
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i-1] * nums[i-1];
        }

        int r = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            ans[i] = ans[i] * r;
            r = r * nums[i];
        }

        return ans;
    }
}
