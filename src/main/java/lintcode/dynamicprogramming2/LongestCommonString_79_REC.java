package lintcode.dynamicprogramming2;

public class LongestCommonString_79_REC {
    /**
     * @param A: A string
     * @param B: A string
     * @return: the length of the longest common substring.
     */
    //ref  - LongestCommonSubSequence 77 REC solution
    //     - && https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/LongestCommonSubstring.java

    public int longestCommonSubstring(String A, String B) {
        // write your code here
        if (A == null || A.length() == 0 || B == null || B.length() == 0) {
            return 0;
        }

        //init
        int m = A.length();
        int n = B.length();
        boolean checkEqual = false;

        return rec(A, B, m - 1, n - 1, checkEqual);
    }

    private int rec (String A, String B, int posA, int posB, boolean checkEqual) {
        if (posA == -1 || posB == -1) {
            return 0;
        }

        if (checkEqual) {
            if (A.charAt(posA) == B.charAt(posB)) {
                return 1+ rec(A, B, posA - 1, posB - 1, true);
            }  else {
                return 0;
            }
        }

        int maxWholeString = 0;
        if (A.charAt(posA) == B.charAt(posB)) {
            maxWholeString = 1 + rec(A, B, posA - 1, posB - 1, true);
        }

        int maxSubString = Math.max(rec(A, B, posA, posB - 1, false), rec(A, B, posA - 1, posB, false));

        return Math.max(maxWholeString, maxSubString);
    }

    public static void main(String[] args) {
        String A = "abcdaf";
        String B = "acbcf";

        LongestCommonString_79_REC solution = new LongestCommonString_79_REC ();
        System.out.println(solution.longestCommonSubstring(A, B));
    }

}
