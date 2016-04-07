package ninechapter_algorithm.chapter5_dynamic_prgramming_2.palindromepartitioning2.third;

/**
 * Author: blueaken
 * Date: 4/6/16 11:00 PM
 */
public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    public static int minCut(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }

        //init
        int n = s.length();
        int [] res = new int[n+1];
        res[0] = 0;
        boolean[][] dict = getDict(s);

        //dp
        for (int i = 1; i <= n; i++) {
            res[i] = i;
            for (int j = 0; j < i; j++) {
                if (dict[j][i-1]) {
                    res[i] = Math.min(res[j]+1, res[i]);
                }
            }
        }

        return res[n] - 1;
    }

    private static boolean[][] getDict(String s) {
        int n = s.length();
        boolean[][] dict = new boolean[n][n];

        for (int i = n-1; i>=0; i--) {
            for (int j = i; j < n; j++) {
                dict[i][j] = s.charAt(i) == s.charAt(j)
                        && (j-i < 2 || dict[i+1][j-1]);
            }
        }
        return dict;
    }

    public static void main(String[] args) {
        String s = "aab";

        System.out.println(minCut(s));
    }
}
