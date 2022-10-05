package lintcode.prefixsum;

public class MinFlipsMonoIncr_LE_926_P3 {
    /*
        P1 - ref prev notes
        - For each pos, found how many '1's before (including current pos), aka the prefix sum, and how many '0's after, then add them together,
        flip the before '1's to '0's and the after '0's to '1's to make the string monotone increasing. Repeat at each pos,
        and find the minimum.

        Ref - https://leetcode.com/problems/flip-string-to-monotone-increasing/solution/
        ==========================================================
        P3
        - ref prev notes

    */
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] ps = new int[n+1];
        for (int i = 1; i <= n; i++) {
            ps[i] = ps[i-1] + (s.charAt(i-1) == '1' ? 1 : 0);
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) { //iterate from 0 to cover case when the whole string is all 0s or 1s
            int afterPos = n - i;
            int afterOnes = ps[n] - ps[i];
            int afterZeros = afterPos - afterOnes;

            ans = Math.min(ans, ps[i] + afterZeros);
        }
        return ans;
    }
}
