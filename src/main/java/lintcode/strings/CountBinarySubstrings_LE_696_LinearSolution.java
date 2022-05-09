package lintcode.strings;

// using DP LPS template, O(N^2) time, get TLE. Ref to solutions get O(N), not an easy question for sure.
// Ref - https://leetcode.com/problems/count-binary-substrings/solution/
/* Notes -
        We can convert the string s into an array groups that represents the length of same-character contiguous
        blocks within the string. For example, if s = "110001111000000", then groups = [2, 3, 4, 6].

        For every binary string of the form '0' * k + '1' * k or '1' * k + '0' * k, the middle of this string must
         occur between two groups.

        Let's try to count the number of valid binary strings between groups[i] and groups[i+1]. If we have
        groups[i] = 2, groups[i+1] = 3, then it represents either "00111" or "11000". We clearly can make
        min(groups[i], groups[i+1]) valid binary strings within this string. Because the binary digits to the left or
        right of this string must change at the boundary, our answer can never be larger.
*/
public class CountBinarySubstrings_LE_696_LinearSolution {
    public int countBinarySubstrings(String s) {
        int[] groups = new int[s.length()];
        int t = 0;
        groups[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i-1)) {
                groups[++t] = 1;
            } else {
                groups[t] += 1;
            }
        }

        int res = 0;
        for (int i = 1; i <= t; i++) {
            res += Math.min(groups[i-1], groups[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        CountBinarySubstrings_LE_696_LinearSolution solution = new CountBinarySubstrings_LE_696_LinearSolution();
//        String input = "10101"; //4
        String input = "00110011"; //6

        System.out.println(solution.countBinarySubstrings(input));
    }
}
