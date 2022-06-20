package lintcode.dynamicprogramming2;

import java.util.ArrayList;
import java.util.List;

public class WordBreak_LE_139_Space_Optimization_P1 {
    /*
        - retry with O(N) space, a gut feeling is LPS DP can always transfer to O(N) space, like jump game problem
        - time still O(N^3) though, 2 nested loop plus one substring computation at each iteration.
    */
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }

        int size = s.length();
        boolean[] res = new boolean[size + 1];
        res[0] = true; //empty string always fit
        for (int i = 1; i <= size; i++) {
            for (int j = 0; j < i; j++) {
                String cur = s.substring(j, i);
                if (res[j] && wordDict.contains(cur)) {
                    res[i] = true;
                    break;
                }
            }
        }
        return res[size];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> dict = new ArrayList<>();
        dict.add("leet");
        dict.add("code");

        WordBreak_LE_139_Space_Optimization_P1 solution = new WordBreak_LE_139_Space_Optimization_P1();
        System.out.println(solution.wordBreak(s, dict));
    }
}
