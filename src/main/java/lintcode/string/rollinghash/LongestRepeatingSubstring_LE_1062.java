package lintcode.string.rollinghash;

public class LongestRepeatingSubstring_LE_1062 {
    /*
        ref https://www.youtube.com/watch?v=ONT_PrPdMuQ
        - exactly same as 1044, but the diff is s.length is less than 2000, which means can use O(N^2) solution
          and we use DP
        - similar to Longest Common Substring
    */
    public int longestRepeatingSubstring(String s) {
        int n = s.length();
        int[][] res = new int[n+1][n+1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                //skip to compre whole string, which is different to LCS
                if (i != j && s.charAt(i-1) == s.charAt(j-1)) {
                    res[i][j] = res[i-1][j-1] + 1;
                }
                ans = Math.max(ans, res[i][j]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestRepeatingSubstring_LE_1062 solution = new LongestRepeatingSubstring_LE_1062();
        String s = "abbab";//2
        System.out.println(solution.longestRepeatingSubstring(s));
    }
}
