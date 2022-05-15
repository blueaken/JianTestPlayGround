package lintcode.dynamicprogramming2;

import java.util.ArrayList;
import java.util.List;

public class WordBreak_LE_139 {
    /*
        - try Tushor's DP, it should work but the time is O(N^3), N is the length of the String.
    */
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }

        int size = s.length();
        boolean[][] res = new boolean[size][size];

        for (int len = 1; len <= size; len++) {
            for (int i = 0; i <= size - len; i++) {
                int j = i + len - 1;
                String cur = s.substring(i, j + 1);
                if (wordDict.contains(cur)) {
                    res[i][j] = true;
                    continue;
                }

                for (int k = i + 1; k <= j; k++) {
                    if (res[i][k-1] && res[k][j]) {
                        res[i][j] = true;
                        break;
                    }
                }

            }
        }
        return res[0][size-1];
    }

    public static void main(String[] args) {
        WordBreak_LE_139 solution = new WordBreak_LE_139();
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        //true

        System.out.println(solution.wordBreak(s, wordDict));
    }
}
