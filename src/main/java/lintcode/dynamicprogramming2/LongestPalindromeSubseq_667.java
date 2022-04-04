package lintcode.dynamicprogramming2;

public class LongestPalindromeSubseq_667 {
    /**
     * @param s: the maximum length of s is 1000
     * @return: the longest palindromic subsequence's length
     */
    //Ref - https://www.youtube.com/watch?v=_nCsPn7_OgI
    //    the loop similar to Word Break (107)
    public int longestPalindromeSubseq(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        //init
        int size = s.length();
        int[][] res = new int[size][size];
        for (int i = 0; i < size; i++) {
            res[i][i] = 1;
        }

        for (int len = 2; len <= size; len++) {
            for (int start = 0; start < size - len + 1; start++) {
                int end = start + len - 1;
                //handle special case when len == 2
                if (len == 2 && s.charAt(start) == s.charAt(end)) {
                    res[start][end] = 2;
                }
                if (s.charAt(start) == s.charAt(end)) {
                    res[start][end] = 2 + res[start+1][end-1];
                } else {
                    res[start][end] = Math.max(res[start][end-1], res[start+1][end]);
                }
            }
        }
        return res[0][s.length()-1];
    }

    public static void main(String[] args) {
        String input = "bbbab";

        LongestPalindromeSubseq_667 solution = new LongestPalindromeSubseq_667();
        System.out.println(solution.longestPalindromeSubseq(input));
    }
}
