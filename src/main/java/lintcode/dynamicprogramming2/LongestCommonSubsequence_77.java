package lintcode.dynamicprogramming2;

public class LongestCommonSubsequence_77 {
    /**
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     */
    //Idea: ref 2D Array pattern and https://www.youtube.com/watch?v=NnD96abizww
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if (A == null || B == null) {
            return 0;
        }

        //init
        int m = A.length();
        int n = B.length();
        int[][] res = new int[m+1][n+1];

        //dp
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i-1) == B.charAt(j-1)) {
                    res[i][j] = res[i-1][j-1] + 1;
                } else {
                    res[i][j] = Math.max(res[i-1][j], res[i][j-1]);
                }
            }
        }

        return res[m][n];
    }
}
