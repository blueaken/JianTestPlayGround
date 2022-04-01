package lintcode.dynamicprogramming2;

import java.util.HashSet;
import java.util.Set;

public class WordBreak_107_2nd {

    /**
     * @param s: A string
     * @param wordSet: A dictionary of words dict
     * @return: A boolean
     */
    //Ref Tushar's video - https://www.youtube.com/watch?v=WepWFGxiwRs
    public boolean wordBreak(String s, Set<String> wordSet) {
        // write your code here
        if (s == null || s.length() == 0) {
            return wordSet == null || wordSet.size() == 0;
        }

        int size = s.length();
        boolean[][] res = new boolean[size][size];

        for (int len = 1; len <= size; len++) {
            for (int start = 0; start < size - len + 1; start++) {
                int end = start + len - 1;
                String curStr = s.substring(start, end + 1);
                if (wordSet.contains(curStr)) {
                    res[start][end] = true;
                    continue;
                }

                for (int mid = start + 1; mid <= end; mid++) {
                    if (res[start][mid-1] && res[mid][end]) {
                        res[start][end] = true;
                        break;
                    }
                }
            }
        }
        return res[0][size-1];
    }

    public static void main(String[] args) {
//        String s = "aaab";
//        Set<String> dict = new HashSet<>();
//        dict.add("a");
//        dict.add("b");

        String s = "Iamace";
        Set<String> dict = new HashSet<>();
        dict.add("I");
        dict.add("am");
        dict.add("ace");
        dict.add("a");

        WordBreak_107_2nd solution = new WordBreak_107_2nd();
        System.out.println(solution.wordBreak(s, dict));
    }
}
