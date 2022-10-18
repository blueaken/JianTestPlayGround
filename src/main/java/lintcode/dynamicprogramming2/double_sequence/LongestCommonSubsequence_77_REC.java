package lintcode.dynamicprogramming2.double_sequence;

public class LongestCommonSubsequence_77_REC {
    /**
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     */
    //Ref - https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if (A == null || B == null) {
            return 0;
        }

        int m = A.length();
        int n = B.length();
        return rec (A, B, m, n);
    }

    private int rec (String A, String B, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (A.charAt(m-1) == B.charAt(n-1)) {
            return 1 + rec (A, B, m-1, n-1);
        } else {
            return Math.max(rec(A, B, m, n-1), rec(A, B, m-1, n));
        }
    }

    public static void main(String[] args) {
        String A = "abcdaf";
        String B = "acbcf";

        LongestCommonSubsequence_77_REC solution = new LongestCommonSubsequence_77_REC ();
        System.out.println(solution.longestCommonSubsequence(A, B));
    }
}
