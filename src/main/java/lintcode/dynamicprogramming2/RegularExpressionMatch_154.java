package lintcode.dynamicprogramming2;

public class RegularExpressionMatch_154 {
    /**
     * @param s: A string
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
    // Ref - https://www.youtube.com/watch?v=l3hda49XcDE
    public boolean isMatch(String s, String p) {
        // write your code here
        boolean[][] res = new boolean [s.length() + 1][p.length() + 1];

        //init
        res[0][0] = true;
        //res[i][0] = false, i >= 1, default value

        //in case of a*, a*b*, a*b*c*, etc, OR first char is '*'
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                res[0][j] = j == 1 ? true : res[0][j - 2];
            }
        }

        //dp
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    res[i][j] = res[i - 1][j - 1];
                    continue;
                }
                if (p.charAt(j - 1) == '*') {
                    //case of first pattern char is wildcard, then always true;
                    if (j == 1) {
                        res[i][j] = true;
                        continue;
                    }
                    //case of 0 occurence of previou pattern char
                    if (res[i][j - 2]) {
                        res[i][j] = true;
                        continue;
                    }
                    //case of 1 or more occurences of previou pattern char
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        res[i][j] = res[i - 1][j];
                        continue;
                    }
                }
                // the rest cases are false, default value
            }
        }

        return res[s.length()][p.length()];

    }

    public static void main(String[] args) {
        RegularExpressionMatch_154 solution = new RegularExpressionMatch_154();
        String str = "xaabyc";
        String pattern = "xa*b.c";

//        String str = "aab";
//        String pattern = "c*a*b";

        System.out.println(solution.isMatch(str, pattern));
    }
}
