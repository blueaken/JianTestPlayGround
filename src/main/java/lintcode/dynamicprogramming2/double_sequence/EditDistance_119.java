package lintcode.dynamicprogramming2.double_sequence;

public class EditDistance_119 {
    /**
     * @param word1: A string
     * @param word2: A string
     * @return: The minimum number of steps
     */
    //Idea: ref previous notes
    public int minDistance(String word1, String word2) {
        // write your code here
        if (word1 == null || word2 == null) {
            return -1;
        }

        int m = word1.length();
        int n = word2.length();
        int[][] res = new int[m+1][n+1];
        //init
        for (int i = 0; i <= m; i++) {
            res[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            res[0][i] = i;
        }

        //dp
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    res[i][j] = res[i-1][j-1];
                } else {
                    res[i][j] = getMin(res[i-1][j-1], res[i][j-1], res[i-1][j]) + 1;
                }
            }
        }
        return res[m][n];
    }

    private int getMin(int a, int b, int c) {
        int min = Math.min(a, b);
        return Math.min(min, c);
    }
}
