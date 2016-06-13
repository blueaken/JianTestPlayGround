package ninechapter_algorithm.chapter1_strstr_to_search_problems.optional.palindromepartition.fourth;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 6/12/16 20:39
 */
public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }

        boolean[][] dict = getDict(s);
        rec(result, s, new ArrayList<String>(), dict, 0);
        return result;
    }

    private void rec(List<List<String>> result, String s, List<String> list, boolean[][] dict, int index) {
        if (index == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (dict[index][i]) {
                list.add(s.substring(index, i + 1));
                rec(result, s, list, dict, i + 1);
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        String test = "aab";
        System.out.println(solution.partition(test));
    }
}
