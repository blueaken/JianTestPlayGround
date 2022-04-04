package lintcode.dynamicprogramming2;

public class LongestPalindromeSubseq_667_REC {
    /**
     * @param s: the maximum length of s is 1000
     * @return: the longest palindromic subsequence's length
     */
    //Recursive Solution
    public int longestPalindromeSubseq(String s) {
        // write your code here
        return rec (s, 0, s.length());
    }

    private int rec (String s, int start, int len) {
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return 1;
        }

        if (s.charAt(start) == s.charAt(start + len - 1)) {
            return 2 + rec(s, start + 1, len - 2);
        } else {
            return Math.max(rec (s, start, len - 1), rec (s, start + 1, len - 1));
        }
    }

    public static void main(String[] args) {
        String input = "bbbab";

        LongestPalindromeSubseq_667_REC solution = new LongestPalindromeSubseq_667_REC();
//        long startTime = System.currentTimeMillis();
        System.out.println(solution.longestPalindromeSubseq(input));
//        long endTime = System.currentTimeMillis();
//        System.out.println("Run Time in MilliSeconds: " + (endTime - startTime));
    }
}
