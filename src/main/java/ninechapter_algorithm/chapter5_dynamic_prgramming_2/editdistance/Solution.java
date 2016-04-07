package ninechapter_algorithm.chapter5_dynamic_prgramming_2.editdistance;

/**
 * Author: blueaken
 * Date: 4/7/16 12:27 PM
 */
public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public static int minDistance(String word1, String word2) {
        // write your code here
        int n = word1.length();
        int m = word2.length();
        int[][] res = new int[n+1][m+1];

        //init
        for (int i = 0; i <= n; i++) {
            res[i][0] = i;
        }
        for (int i = 1; i <= m; i++) {
            res[0][i] = i;
        }

        //dp
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    //res[i][j] = Math.min(Math.min(res[i-1][j] + 1, res[i][j-1] + 1), res[i-1][j-1]);
                    res[i][j] = res[i-1][j-1];
                } else {
                    res[i][j] = Math.min(Math.min(res[i-1][j] + 1, res[i][j-1] + 1), res[i-1][j-1]+1);
                }
            }
        }

        return res[n][m];
    }

    public static void main(String[] args) {
        String A = "mart";
        String B = "karma";

//        String A = "mart";
//        String B = "";

        System.out.println(minDistance(A, B));
    }
}
