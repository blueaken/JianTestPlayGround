package lintcode.math;

import java.util.Arrays;

public class SumOfSubsequenceWidths_LE_891 {
    /*
        - ref https://leetcode.com/problems/sum-of-subsequence-widths/discuss/2176301/JAVA-EASY-COMMENTED-SOLUTION & Huifeng Guan webpage
        - since the order does not matter, we sort it first
        - for any element nums[i] in the sorted array, it plays in the answer only when it is max and min of a subsequence. For each nums[i], there are 2^i possibilities of max, and 2^(n-i) possibilities of min, once this is figured out, we can easily solve this in O(NLogN) + O(N) = O(NLogN).
        - can be further optimized, but this version should be good for interview
    */
    public int sumSubseqWidths(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        //have to pre calc power to avoid overflow
        int mod = (int)1e9 + 7;
        long[] power = new long[n];
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            power[i] = power[i-1] * 2 % mod;
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + nums[i] * power[i] - nums[i] * power[n - i -1]) % mod;
        }
        return (int)ans;
    }

    // 0 1 2 3 4 5
    // X X X i X X
    //       i - max, 2^3种sub sequence，因为已排序
    //         - min, 2^(6-3-1)种sub sequence
}
