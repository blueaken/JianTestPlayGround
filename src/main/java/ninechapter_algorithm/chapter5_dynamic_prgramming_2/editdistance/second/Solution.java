package ninechapter_algorithm.chapter5_dynamic_prgramming_2.editdistance.second;

/**
 * Author: blueaken
 * Date: 7/5/16 16:45
 */
public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // write your code here
        if (word1 == null || word2 == null) {
            return -1;
        }

        //init
        int m = word1.length();
        int n = word2.length();
        int[][] res = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            res[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            res[0][i] = i;
        }

        //dp
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    res[i][j] = res[i - 1][j - 1];
                } else {
                    res[i][j] = Math.min(Math.min(res[i - 1][j], res[i][j - 1]), res[i - 1][j - 1]) + 1;
                }
            }
        }

        return res[m][n];
    }

}
