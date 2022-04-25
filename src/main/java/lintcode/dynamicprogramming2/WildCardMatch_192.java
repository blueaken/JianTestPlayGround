package lintcode.dynamicprogramming2;

public class WildCardMatch_192 {
    /**
     * @param s: A string
     * @param p: A string includes "?" and "*"
     * @return: is Match?
     */
     /* Idea - very similar to 154, '?' is same as '.', but RE '*' refers to 0 or multiple occurance
               of any chars, wildcard '*' refers to 0 or more multiple occurance of the char before
        Ref - https://www.youtube.com/watch?v=3ZDZ-N0EPV0
            - https://www.youtube.com/watch?v=l3hda49XcDE
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        boolean[][] res = new boolean[s.length() + 1][p.length() + 1];

        //init
        res[0][0] = true;
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                res[0][j] = res[0][j - 1];
            }
        }

        //dp
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    res[i][j] = res[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (j == 1) {
                        res[i][j] = true;
                        continue;
                    }
                    //case of 0 occurance || 1 occurance
                    res[i][j] = res[i][j - 1] || res[i - 1][j];
                }
                // res[i][j] = false; default value;
            }
        }

        return res[s.length()][p.length()];
    }

    public static void main(String[] args) {
        WildCardMatch_192 solution = new WildCardMatch_192();
//        String str = "aab";
//        String pattern = "c*a*b";

//        String str = "aaa";
//        String pattern = "*";

//        String str = "aa";
//        String pattern = "?*";

        String str = "aaaa";
        String pattern = "a*";

        System.out.println(solution.isMatch(str, pattern));
    }
}
