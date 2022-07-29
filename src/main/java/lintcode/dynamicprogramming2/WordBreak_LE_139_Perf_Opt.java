package lintcode.dynamicprogramming2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak_LE_139_Perf_Opt {
    /*
        - revisit ref 花花酱的讲解： https://www.youtube.com/watch?v=ptlwluzeC1I
        - 他用了递归方式来讲解，并对DFS进行了记忆优化提高了效率
    */

    //global memory to optimize time performance
    public Map<String, Boolean> mem = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }

        //using Map to optimize the performance
        if (mem.containsKey(s)) {
            return mem.get(s);
        }
        //if whole word is in the dictionary, return true
        if (wordDict.contains(s)) {
            return true;
        }

        for (int i = 1; i < s.length(); i++) {
            //if right part not in the dictionary then continue, improve time perf
            String right = s.substring(i);
            if (!wordDict.contains(right)) {
                continue;
            }

            String left = s.substring(0, i);
            if (wordBreak(left, wordDict) && wordDict.contains(right)) {
                mem.put(s, true);
                return true;
            }
        }
        mem.put(s, false);
        return false;
    }

    public static void main(String[] args) {
        WordBreak_LE_139_Perf_Opt solution = new WordBreak_LE_139_Perf_Opt();

        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        //true
        System.out.println(solution.wordBreak(s, wordDict));
    }
}
