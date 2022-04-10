package lintcode.dynamicprogramming2;

public class InterleavingString_29_REC {
    /**
     * @param s1: A string
     * @param s2: A string
     * @param s3: A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     */
    //Ref - https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/TwoStringInterleavingToFormThird.java
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        return rec (s1, 0, s2, 0, s3, 0);
    }

    private boolean rec (String s1, int pos1, String s2, int pos2, String s3, int pos3) {
        if (pos1 == s1.length() && pos2 == s2.length() && pos3 == s3.length()) {
            return true;
        }
        if (pos3 == s3.length()) {
            return false;
        }

        return  (pos1 < s1.length() && s1.charAt(pos1) == s3.charAt(pos3) && rec(s1, pos1+1, s2, pos2, s3, pos3+1)
            || pos2 < s2.length() && s2.charAt(pos2) == s3.charAt(pos3) && rec(s1, pos1, s2, pos2+1, s3, pos3+1));
    }

    public static void main(String[] args) {
        String s1 = "aab";
        String s2 = "axy";
//        String s3 = "aaxaby"; //true
        String s3 = "abaaxy"; //false

        InterleavingString_29_REC solution = new InterleavingString_29_REC();
        System.out.println(solution.isInterleave(s1, s2, s3));
    }
}
