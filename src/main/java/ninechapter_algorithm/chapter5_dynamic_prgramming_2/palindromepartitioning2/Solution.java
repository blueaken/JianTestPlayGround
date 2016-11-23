package ninechapter_algorithm.chapter5_dynamic_prgramming_2.palindromepartitioning2;

/**
 * Author: blueaken
 * Date: 3/4/16 11:36 AM
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

        //prep
        boolean[][] isPanli = getPanliDict(s);
        int[] res = new int[s.length()+1];
        res[0] = 0;

        //dp
        for (int i = 0; i < s.length(); i++) {
            res[i+1] = i+1;
            for (int j = 0; j <= i; j++) {
                if (isPanli[j][i]) {
                    res[i+1] = Math.min(res[i+1], res[j]+1);
                }
            }
        }

        return res[s.length()] - 1;
    }

    private static boolean[][] getPanliDict(String s) {
        boolean[][] isPanli = new boolean[s.length()][s.length()];
        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j-i<2 || isPanli[i+1][j-1])) {
                    isPanli[i][j] = true;
                }
            }
        }
        return isPanli;
    }

    public static void main(String[] args) {
        String s = "aab";

        System.out.println(minCut(s));
    }
}
