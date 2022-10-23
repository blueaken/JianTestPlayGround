package lintcode.dynamicprogramming2.double_sequence;

import java.util.Arrays;

public class WildcardMatching_LE_044 {
    /*
        ref labuladong post
        - similar to 010, the diff is here '*' refers to 0 or any occurance of any chars, has nothing to do with the previous char
        - similarly solve with top down dp with mem cache
    */
    int[][] mem; //-1 - unvisited, 1 - true, 0 - false;
    public boolean isMatch(String s, String p) {
        mem = new int[s.length()][p.length()];
        for (int[] arr : mem) {
            Arrays.fill(arr, -1);
        }

        //can be further optimized to remove adjacent '*'s if any, skip now

        return dp(s, 0, p, 0);
    }

    private boolean dp(String s, int i, String p, int j) {
        int m = s.length();
        int n = p.length();
        //base case
        if (j == n) {
            return i == m;
        }
        if (i == m) {
            int pos = j;
            while (pos < n) {
                if (p.charAt(pos) != '*') {
                    return false;
                }
                pos++;
            }
            return true;
        }

        if (mem[i][j] != -1) {
            return mem[i][j] == 1 ? true : false;
        }

        boolean res = false;
        //当前字符匹配
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            //常规匹配1次
            res = dp(s, i+1, p, j+1);
        } else if (p.charAt(j) == '*') {
            //当前字符不匹配时，通配符匹配0次或者多次
            res = dp(s, i, p, j+1) || dp(s, i+1, p, j);
        }
        mem[i][j] = res ? 1 : 0;
        return res;
    }
}
