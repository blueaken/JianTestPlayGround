package lintcode.greedy;

public class MinNumberOfSwapsToMakeBinaryStringAlternating_LE_1864_P1 {
    /*
        ref - https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-binary-string-alternating/discuss/2472213/Java-Beats-100-oror-O(n)-one-pass-solution-oror-Explanation-with-comments
        - good idea with comments above
        ========================
        P1 11.02.2022
        ========================
    */
    public int minSwaps(String s) {
        int n = s.length();
        int c0 = 0, c1 = 0;
        int evenSwap = 0, oddSwap = 0;

        //count 1s, 0s, and swap nums at both even and odd positions for 0s in one pass
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                c0++;
                if (i % 2 == 0) {
                    evenSwap++;
                } else {
                    oddSwap++;
                }
            } else {
                c1++;
            }
        }

        //to make string alternating, the diff of 1s and 0s cannot be more than 1
        if (Math.abs(c0 - c1) > 1) {
            return -1;
        }

        if (c1 > c0) {
            //pattern is 10101...
            return evenSwap;
        } else if (c0 > c1) {
            //pattern is 01010...
            return oddSwap;
        } else {
            // if 1s and 0s are same, then return the min swaps of even and odd positions
            return Math.min(evenSwap, oddSwap);
        }
    }
}
