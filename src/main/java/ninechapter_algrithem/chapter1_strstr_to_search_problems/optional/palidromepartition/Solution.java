package ninechapter_algrithem.chapter1_strstr_to_search_problems.optional.palidromepartition;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 3/25/16 11:10 AM
 */
public class Solution {
    public static List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }

        rec(getDict(s), result, new ArrayList<String>(), 0, s);
        return result;
    }

    private static void rec(boolean[][] dict, List<List<String>> result, List<String> temp, int start, String s){
        if (start == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (dict[start][i]) {
                temp.add(s.substring(start, i+1));
                rec(dict, result, temp, i+1, s);
                temp.remove(temp.size()-1);
            }
        }
    }

    private static boolean[][] getDict(String s) {
        boolean[][] dict = new boolean[s.length()][s.length()];
        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j-i<=2 || dict[i+1][j-1])) {
                    dict[i][j] = true;
                }
            }
        }

        return dict;
    }

    public static void main(String[] args) {
//        String s = "aab";
//        String t = s.substring(3,4);
//        String s = "bb";
        String s = "abbab";

        System.out.println(partition(s));
    }
}
