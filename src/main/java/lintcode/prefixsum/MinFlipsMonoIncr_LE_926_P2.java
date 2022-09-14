package lintcode.prefixsum;

public class MinFlipsMonoIncr_LE_926_P2 {
    /*
        P1 - ref prev notes
        - For each pos, found how many '1's before (including current pos), aka the prefix sum, and how many '0's after, then add them together,
        flip the before '1's to '0's and the after '0's to '1's to make the string monotone increasing. Repeat at each pos,
        and find the minimum.

        Ref - https://leetcode.com/problems/flip-string-to-monotone-increasing/solution/
    */
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] p1 = new int[n+1];
        for (int i = 1; i <= n; i++) {
            p1[i] = p1[i-1] + (s.charAt(i-1) == '1' ? 1 : 0);
        }

        int ans = Integer.MAX_VALUE;
        //note: i needs to start from 0, to include the min flip position is in the after zeros.
        for (int i = 0; i <= n; i++) {
            int after_pos_num = n - i;
            int after_ones = p1[n] - p1[i];
            int after_zeros = after_pos_num - after_ones;

            int cur = p1[i] + after_zeros;
            ans = Math.min(ans, cur);
        }
        return ans;
    }
}
