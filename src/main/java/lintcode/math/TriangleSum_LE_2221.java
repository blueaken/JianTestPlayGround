package lintcode.math;

import java.util.Arrays;

public class TriangleSum_LE_2221 {
    /*
        - Need array copy method:
        - the strongest is System.arraycopy(Object src, int srcPos, Object dest,
                             int destPos, int length) Method, has every parameter specified
        - the easier to use is Arrays.copyOfRange(int[] original, int from, int to), from - inclusive, to - exclusive
    */

    int[] temp;

    public int triangularSum(int[] nums) {

        int n = nums.length;
        temp = new int[n];
        return helper(nums, n);
    }

    private int helper(int[] nums, int n) {
        if (n == 1) {
            return nums[0];
        }

        for (int i = 0; i < n - 1; i++) {
            temp[i] = (nums[i] + nums[i+1]) % 10;
        }
        nums = Arrays.copyOfRange(temp, 0, n - 1);

        return helper(nums, n - 1);
    }
}
