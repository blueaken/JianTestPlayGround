package ninechapter_algorithm.chapter1_strstr_to_search_problems.optional.palindromepartition.third;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 5/5/16 11:47
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
        rec(s, dict, 0, result, new ArrayList<String>());
        return result;
    }

    private void rec(String s, boolean[][] dict, int index,
                     List<List<String>> result, List<String> item) {
        if (index == s.length()) {
            result.add(new ArrayList<>(item));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String cur = s.substring(index, i+1);
            if (dict[index][i]) {
                item.add(cur);
                rec(s, dict, i + 1, result, item);
                item.remove(item.size() - 1);
            }
        }
    }

    private boolean[][] getDict(String s) {
        int len = s.length();
        boolean[][] dict = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dict[i+1][j-1])) {
                    dict[i][j] = true;
                }
            }
        }
        return dict;
    }
}
