package ninechapter_algorithm.chapter1_strstr_to_search_problems.optional.wordbreak2.second;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Author: blueaken
 * Date: 6/19/16 11:08
 */
public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }

        rec(s, wordDict, result, new ArrayList<String>(), 0);
        return result;
    }

    private void rec(String s, Set<String> wordDict, List<String> result, List<String> temp, int index) {
        if (index == s.length()) {
            result.add(getStringFromList(temp));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String cur = s.substring(index, i + 1);
            if (wordDict.contains(cur)) {
                temp.add(cur);
                rec(s, wordDict, result, temp, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private String getStringFromList(List<String> temp) {
        StringBuilder sb = new StringBuilder();
        for (String s : temp) {
            sb.append(s);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "catsanddog";
        Set<String> dict = new HashSet<String>() {{
            add("cat");
            add("cats");
            add("and");
            add("sand");
            add("dog");
        }};

        System.out.println(solution.wordBreak(s, dict));
    }
}
