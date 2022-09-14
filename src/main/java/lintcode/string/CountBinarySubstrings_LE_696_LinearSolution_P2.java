package lintcode.string;

public class CountBinarySubstrings_LE_696_LinearSolution_P2 {
    /*
        P1
        - read prev notes
        ===================================================
        // using DP LPS template, O(N^2) time, get TLE. Ref to solutions get O(N), not an easy question for sure.
// Ref - https://leetcode.com/problems/count-binary-substrings/solution/

        We can convert the string s into an array groups that represents the length of same-character contiguous
        blocks within the string. For example, if s = "110001111000000", then groups = [2, 3, 4, 6].

        For every binary string of the form '0' * k + '1' * k or '1' * k + '0' * k, the middle of this string must
         occur between two groups.

        Let's try to count the number of valid binary strings between groups[i] and groups[i+1]. If we have
        groups[i] = 2, groups[i+1] = 3, then it represents either "00111" or "11000". We clearly can make
        min(groups[i], groups[i+1]) valid binary strings within this string. Because the binary digits to the left or
        right of this string must change at the boundary, our answer can never be larger.
        ===================================================
    */
    public int countBinarySubstrings(String s) {
        int n = s.length();
        int[] group = new int[n];
        int group_id = 0, count = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) != s.charAt(i-1)) {
                group[group_id] = count;
                group_id++;
                count = 0;
            }
            count++;
        }
        group[group_id] = count; //need add the last group

        int ans = 0;
        for (int i = 0; i < group_id; i++) {
            ans += Math.min(group[i], group[i+1]);
        }
        return ans;
    }
}
