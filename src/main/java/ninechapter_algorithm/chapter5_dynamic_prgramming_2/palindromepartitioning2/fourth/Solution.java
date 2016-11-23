package ninechapter_algorithm.chapter5_dynamic_prgramming_2.palindromepartitioning2.fourth;

/**
 * Author: blueaken
 * Date: 7/7/16 11:43
 */
public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        // write your code here
        if (s == null) {
            return 0;
        }

        //init
        int len = s.length();
        boolean[][] dict = getDict(s);
        int[] res = new int[len + 1];

        //dp
        for (int i = 1; i <= len; i++) {
            res[i] = i;
            for (int j = 0; j < i; j++) {
                if (dict[j][i - 1]) {
                    res[i] = Math.min(res[i], res[j] + 1);
                }
            }
        }
        return res[len] - 1;
    }

    private boolean[][] getDict(String s) {
        int len = s.length();
        boolean[][] dict = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                dict[i][j] = s.charAt(i) == s.charAt(j) && ((j - i < 2) || dict[i + 1][j - 1]);
            }
        }
        return dict;
    }
}
