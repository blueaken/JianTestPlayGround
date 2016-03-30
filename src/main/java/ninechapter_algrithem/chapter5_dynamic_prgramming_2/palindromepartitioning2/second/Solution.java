package ninechapter_algrithem.chapter5_dynamic_prgramming_2.palindromepartitioning2.second;

/**
 * Author: blueaken
 * Date: 3/30/16 9:25 AM
 */
public class Solution {
    public static int minCut(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        //init
        int[] res = new int[s.length()+1];
        boolean[][] dict = getDict(s);
        res[0] = 0;

        //dp
        for (int i = 0; i < s.length(); i++) {
            res[i+1] = i+1;
            for (int j = 0; j <= i; j++) {
                if (dict[j][i]) {
                    res[i+1] = Math.min(res[i+1], res[j]+1);
                }
            }
        }

        return res[s.length()]-1;
    }

    private static boolean[][] getDict(String s) {
        boolean[][] dict = new boolean[s.length()][s.length()];
        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                dict[i][j] = (s.charAt(i) == s.charAt(j) && (j-i < 2 || dict[i+1][j-1]));
            }
        }
        return dict;
    }

    public static void main(String[] args) {
        String test = "aabbb";
        System.out.println(minCut(test));
    }
}
