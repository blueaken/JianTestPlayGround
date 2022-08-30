package lintcode.string;

public class MinNumberOfSwapsToMakeBinaryStringAlternating_LE_1864 {
    /*
        ref - https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-binary-string-alternating/discuss/2472213/Java-Beats-100-oror-O(n)-one-pass-solution-oror-Explanation-with-comments
        - good idea with comments above
    */
    public int minSwaps(String s) {
        int n = s.length();
        int c0 = 0, c1 = 0;
        int evenSwaps = 0, oddSwaps = 0;

        //count 1s, 0s, and swap nums at both even and odd positions for 0s in one pass
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                c0++;
                if (i % 2 == 0) {
                    evenSwaps++;
                } else {
                    oddSwaps++;
                }
            } else{
                c1++;
            }
        }

        //to make string alternating, the diff of 1s and 0s cannot be more than 1
        if (Math.abs(c0 - c1) > 1) {
            return -1;
        }

        //if string is odd length, and 1s more than 0s, then 1 should be in even positions, return even swaps of 0s, vice versa
        if (c1 > c0) {
            return evenSwaps;
        } else if (c0 > c1) {
            return oddSwaps;
        } else {
            // if 1s and 0s are same, then return the min swaps of even and odd positions
            return Math.min(evenSwaps, oddSwaps);
        }

    }
}
