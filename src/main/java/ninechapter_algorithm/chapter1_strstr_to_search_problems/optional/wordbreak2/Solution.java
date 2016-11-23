package ninechapter_algorithm.chapter1_strstr_to_search_problems.optional.wordbreak2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Author: blueaken
 * Date: 3/31/16 8:58 AM
 */
public class Solution {
    public static List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }

        rec(s, wordDict, result, new ArrayList<String>(), 0);
        return result;
    }

    private static void rec(String s, Set<String> wordDict, List<String> result, List<String> list, int start) {
        if (start == s.length()) {
            if (isValid(list, s)) {
                result.add(buildStringFromList(list));
            }
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String cur = s.substring(start, i+1);
            if (wordDict.contains(cur)) {
                list.add(cur);
                rec(s, wordDict, result, list, i+1);
                list.remove(list.size()-1);
            }
        }
    }

    private static String buildStringFromList(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    private static boolean isValid(List<String> list, String source) {
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
        }
        return source.equals(sb.toString());
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        Set<String> dict = new HashSet<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");

        System.out.println(wordBreak(s, dict));
    }
}
