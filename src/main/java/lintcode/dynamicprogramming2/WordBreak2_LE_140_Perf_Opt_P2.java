package lintcode.dynamicprogramming2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak2_LE_140_Perf_Opt_P2 {
    /*
        - similar to 139. follow 花花酱视频，重做一下，改善运行时间
        - https://www.youtube.com/watch?v=JqOIRBC0_9c
        - Time is O(N^2) - 看递归调用的数量
        ========================
        P1 - 10.6.2022
        ========================
        P2 - 10.28.2022
        ========================
    */
    Map<String, List<String>> mem = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (mem.containsKey(s)) {
            return mem.get(s);
        }

        List<String> ans = new ArrayList<>();
        if (wordDict.contains(s)) {
            ans.add(s);
        }

        for (int i = 1; i < s.length(); i++) {
            String right = s.substring(i);
            if (!wordDict.contains(right)) {
                continue;
            }

            String left = s.substring(0, i);
            List<String> temp = append(wordBreak(left, wordDict), right);

            //notice cannot use cache yet, since the result for Key s is not settled
            for (String str : temp) {
                ans.add(str);
            }
        }

        mem.put(s, ans);
        return mem.get(s);
    }

    private List<String> append(List<String> list, String str) {
        List<String> res = new ArrayList<>();
        for (String cur : list) {
            res.add(cur + " " + str);
        }
        return res;
    }
}
