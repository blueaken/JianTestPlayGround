package lintcode.dynamicprogramming2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak_LE_139_Perf_Opt_P1 {
    /*
        P1
        - use mem cache to optimize perf
        - note it is similar to 472, but the diff is 472 does not count the small word, and this problem counts, so 472 cannot completely copy this solution, need to use Trie instead
    */
    Map<String, Boolean> mem = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {

        if (mem.containsKey(s)) {
            return mem.get(s);
        }

        if (wordDict.contains(s)) {
            return true;
        }

        for (int i = 1; i < s.length(); i++) {
            String right = s.substring(i);
            if (!wordDict.contains(right)) {
                continue;
            }

            String left = s.substring(0, i);
            if (wordBreak(left, wordDict)) {
                mem.put(s, true);
                return true;
            }
        }
        mem.put(s, false);

        return false;
    }
}
