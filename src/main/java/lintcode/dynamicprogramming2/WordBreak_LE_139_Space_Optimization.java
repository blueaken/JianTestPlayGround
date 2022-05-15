package lintcode.dynamicprogramming2;

import java.util.List;

public class WordBreak_LE_139_Space_Optimization {
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
        res[0] = true; //empty string always fits

        for (int i = 1; i <= size; i++) {
            for (int j = 0; j < i; j++) {
                if (res[j] && wordDict.contains(s.substring(j, i))) {
                    res[i] = true;
                    break;
                }
            }
        }
        return res[size];
    }
}
