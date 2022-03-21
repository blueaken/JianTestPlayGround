package lintcode.dynamicprogramming2;

public class PalindromePartitioning2_108 {
    /**
     * @param s a string
     * @return an integer
     */
    //Idea: ref previous note, get the idea, but very error prone
    public static int minCut(String s) {
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

    private static boolean[][] getDict(String s) {
        int len = s.length();
        boolean[][] dict = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                dict[i][j] = s.charAt(i) == s.charAt(j) && ((j - i < 2) || dict[i + 1][j - 1]);
            }
        }
        return dict;
    }

    public static void main(String[] args) {
//        String input = "aab";
        String input = "leet";

        PalindromePartitioning2_108 solution = new PalindromePartitioning2_108();
        System.out.println(solution.minCut(input));
    }
}
