package ninechapter_algorithm.chapter1_strstr_to_search_problems.optional.palidromepartition.second;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 4/1/16 1:51 PM
 */
public class Solution {
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        rec(s, getDict(s), result, new ArrayList<String>(), 0);
        return result;
    }

    private static void rec(String s, boolean[][] dict, List<List<String>> result, List<String> list, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String cur = s.substring(start, i+1);
            if (dict[start][i]) {
                list.add(cur);
                rec(s, dict, result, list, i+1);
                list.remove(list.size()-1);
            }
        }
    }

    private static boolean[][] getDict(String s) {
        int len = s.length();
        boolean[][] dict = new boolean[len][len];
        for (int i = len-1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                dict[i][j] = s.charAt(j) == s.charAt(i) && (j-i < 2 || dict[i+1][j-1]);
            }
        }
        return dict;
    }

    public static void main(String[] args) {
        String s = "aab";
//        String t = s.substring(3,4);
//        String s = "bb";
//        String s = "abbab";

        System.out.println(partition(s));
    }
}
