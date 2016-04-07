package ninechapter_algorithm.chapter5_dynamic_prgramming_2.interleavestring;

/**
 * Author: blueaken
 * Date: 4/7/16 4:10 PM
 */
public class Solution {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public static boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        int n = s1.length();
        int m = s2.length();
        int len = s3.length();
        if (n + m != len) {
            return false;
        }

        //init
        boolean[][] res = new boolean[n+1][m+1];
        res[0][0] = true;
        for (int i = 1; i <= n; i++) {
            String sub1 = s1.substring(0, i);
            String sub3 = s3.substring(0, i);
            res[i][0] = sub1.equals(sub3);
        }
        for (int i = 1; i <= m; i++) {
            String sub2 = s2.substring(0, i);
            String sub3 = s3.substring(0, i);
            res[0][i] = sub2.equals(sub3);
        }

        //dp
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                res[i][j] =
                        s1.charAt(i-1) == s3.charAt(i+j-1) && res[i-1][j]
                    || s2.charAt(j-1) == s3.charAt(i+j-1) && res[i][j-1];
            }
        }

        return res[n][m];
    }

    public static void main(String[] args) {
        String s1 = "aab";
        String s2 = "axy";

        String s3 = "aaxaby";
        //String s3 = "abaaxy";

        System.out.println(isInterleave(s1, s2, s3));
    }
}
