package lintcode.dynamicprogramming2;

public class InterleavingString_29 {
    /**
     * @param s1: A string
     * @param s2: A string
     * @param s3: A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }
        int m = s1.length();
        int n = s2.length();
        if (s3.length() != (m + n)) {
            return false;
        }

        //init
        boolean[][] res = new boolean[m+1][n+1];
        res[0][0] = true;
        for (int i = 1; i <= m; i++) {
            res[i][0] = s1.substring(0, i).equals(s3.substring(0, i));
        }
        for (int i = 1; i <= n; i++) {
            res[0][i] = s2.substring(0, i).equals(s3.substring(0, i));
        }

        //dp
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                res[i][j] = (s1.charAt(i-1) == s3.charAt(i+j-1) && res[i-1][j])
                        || (s2.charAt(j-1) == s3.charAt(i+j-1) && res[i][j-1]);
            }
        }
        return res[m][n];
    }

    public static void main(String[] args) {
        String s1 = "aab";
        String s2 = "axy";
//        String s3 = "aaxaby"; //true
        String s3 = "abaaxy"; //false

        InterleavingString_29 solution = new InterleavingString_29();
        System.out.println(solution.isInterleave(s1, s2, s3));
    }
}
