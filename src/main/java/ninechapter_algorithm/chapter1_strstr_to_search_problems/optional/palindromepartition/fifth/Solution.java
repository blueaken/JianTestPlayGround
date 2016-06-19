package ninechapter_algorithm.chapter1_strstr_to_search_problems.optional.palindromepartition.fifth;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 6/19/16 09:50
 */
public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        if (s == null) {
            return result;
        }

        boolean[][] dict = getDict(s);
        rec(result, s, dict, new ArrayList<String>(), 0);
        return result;
    }

    private void rec(List<List<String>> result, String s, boolean[][] dict,
                     List<String> list, int index) {
        if (index == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (dict[index][i]) {
                list.add(s.substring(index, i + 1));
                rec(result, s, dict, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean[][] getDict(String s) {
        int len = s.length();
        boolean[][] dict = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                dict[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dict[i + 1][j - 1]);
            }
        }
        return dict;
    }
}
