package lintcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation_1169 {
    /**
     * @param s1: a string
     * @param s2: a string
     * @return: if s2 contains the permutation of s1
     */
    /*
        Idea - use similar way of N Queens and Permutation, DFS way to attack, not ACed,
        the solution looking for a slide window, try next time
     */
    public boolean checkInclusion(String s1, String s2) {
        // write your code here
        if (s1.isEmpty() && s2.isEmpty()) {
            return true;
        }
        if (s1.isEmpty() || s2.isEmpty()) {
            return false;
        }

        List<String> res = new ArrayList<>();
        int size = s1.length();
        StringBuilder sb = new StringBuilder();
        rec (size, 0, s1, sb, res);

        for (String s : res) {
            if (s2.indexOf(s) >= 0) {
                return true;
            }
        }
        return false;
    }

    private void rec (int size, int pos, String str, StringBuilder sb, List<String> res) {
        if (size == pos) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < size; i++) {
            char cur = str.charAt(i);
            //avoid duplicates, otherwise will be exponential
            if (sb.indexOf(String.valueOf(cur)) >= 0) {
                continue;
            }
            sb.append(str.charAt(i));
            rec(size, pos + 1, str, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "eidbadcooo";

        StringPermutation_1169 solution = new StringPermutation_1169();
        System.out.println(solution.checkInclusion(s1, s2));
    }
}
