package lintcode.dynamicprogramming2.double_sequence;

import java.util.Arrays;

public class RegularExpressionMatching_LE_010 {
    /*
        ref labuladong post
        - solve it with TopDown DP with mem cache
    */
    int[][] mem; //-1 unvisited, 0 - false, 1 - true
    public boolean isMatch(String s, String p) {
        mem = new int[s.length()][p.length()];
        for (int[] arr : mem) {
            Arrays.fill(arr, -1);
        }

        //dp - 表示 s[i..]是否可以匹配p[j..]
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
            // 检查是否存在 x*y*z* 这种形式
            if ((n - j) % 2 == 1) { //x*y*z*这种形式，字符一定是成对出现
                return false;
            }

            int pos = j;
            while ((pos+1) < n) {
                if (p.charAt(pos+1) != '*') {
                    return false;
                }
                pos += 2;
            }
            return true;
        }

        if (mem[i][j] != -1) {
            return mem[i][j] == 1 ? true : false;
        }

        boolean res = false;
        //当前字符相匹配
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            if ((j+1) < n && p.charAt(j+1) == '*') {
                //1.1 通配符匹配0次或者多次
                res = dp(s, i, p, j+2) || dp(s, i+1, p, j);
            } else {
                //1.2 常规匹配1次
                res = dp(s, i+1, p, j+1);
            }
        } else {
            //当前字符不匹配
            if ((j+1) < n && p.charAt(j+1) == '*') {
                //2.1 通配符匹配0次
                res = dp(s, i, p, j+2);
            } else {
                res = false;
            }

        }

        mem[i][j] = res ? 1 : 0;
        return res;
    }
}
