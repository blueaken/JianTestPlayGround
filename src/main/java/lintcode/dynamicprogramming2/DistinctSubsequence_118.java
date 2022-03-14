package lintcode.dynamicprogramming2;

public class DistinctSubsequence_118 {
    /**
     * @param S: A string
     * @param T: A string
     * @return: Count the number of distinct subsequences
     */
    //Idea: 2 Sequence DP, ref - https://www.youtube.com/watch?v=InjW43eRq5I
    public int numDistinct(String S, String T) {
        // write your code here
        int m = S.length();
        int n = T.length();
        if (n == 0) {
            return 1;
        }

        //init
        int[][] res = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            // if target String is null, there is one and only one way to
            // form a distinct subsequence
            res[i][0] = 1;
        }

        //dp
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //Note: String index need minus 1 to match the actual position of String
                if (S.charAt(i-1) == T.charAt(j-1)) {
                    res[i][j] = res[i-1][j-1] + res[i-1][j];
                } else {
                    res[i][j] = res[i-1][j];
                }
            }
        }
        return res[m][n];
    }

    public static void main(String[] args) {
        String source = "rabbbit";
        String target = "rabbit";

        DistinctSubsequence_118 solution = new DistinctSubsequence_118();
        System.out.println(solution.numDistinct(source, target));
    }
}
