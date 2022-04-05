package lintcode.dynamicprogramming2;

public class LongestCommonString_79 {
    /**
     * @param A: A string
     * @param B: A string
     * @return: the length of the longest common substring.
     */
    //Idea: ref previous nots - function: f[i][j]
    //                          = f[i-1][j-1] + 1 // A[i - 1] == B[j - 1]
    //                           = 0 // A[i - 1] != B[j - 1]，如果不符合就存零，这样前面substring结果不会影响后面的substring结果
    //      intialize: f[i][0] = 0 f[0][j] = 0
    //       answer: MAX(f[n][m])

    public int longestCommonSubstring(String A, String B) {
        // write your code here
        if (A == null || A.length() == 0 || B == null || B.length() == 0) {
            return 0;
        }

        //init
        int m = A.length();
        int n = B.length();
        int[][] res = new int[m+1][n+1];
        int max = Integer.MIN_VALUE;

        //dp
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                res[i][j] = A.charAt(i-1) == B.charAt(j-1) ? res[i-1][j-1] + 1 : 0;
                max = Math.max(max, res[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String A = "abcdaf";
        String B = "acbcf";

        LongestCommonString_79 solution = new LongestCommonString_79 ();
        System.out.println(solution.longestCommonSubstring(A, B));
    }
}
