package lintcode.dynamicprogramming2;

import java.util.HashSet;
import java.util.Set;

public class WordBreak_107 {
    /**
     * @param s: A string
     * @param wordSet: A dictionary of words dict
     * @return: A boolean
     */
    //Idea: ref previous notes && add maxLength to improve performance, also can be attached with DFS
    //      but it times out, try use maxLength and/or DFS next time
    public boolean wordBreak(String s, Set<String> wordSet) {
        // write your code here
        if (s == null || s.length() == 0) {
            return wordSet == null || wordSet.size() == 0;
        }

        int maxLength = 0;
        for (String str : wordSet) {
            maxLength = Math.max(maxLength, str.length());
        }

        //init
        int len = s.length();
        boolean[] res = new boolean[len+1];
        res[0] = true;

        //dp
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                String cur = s.substring(j, i);
                if (cur.length() > maxLength) {
                    continue;
                }
                if (res[j] && wordSet.contains(cur)) {
                    res[i] = true;
                    break;
                }
            }
        }
        return res[len];
    }

    public static void main(String[] args) {
        String s = "aaab";
        Set<String> dict = new HashSet<>();
        dict.add("a");
        dict.add("b");

//        String s = "lintcode";
//        Set<String> dict = new HashSet<>();
//        dict.add("lint");
//        dict.add("code");

        WordBreak_107 solution = new WordBreak_107();
        System.out.println(solution.wordBreak(s, dict));
    }
}
