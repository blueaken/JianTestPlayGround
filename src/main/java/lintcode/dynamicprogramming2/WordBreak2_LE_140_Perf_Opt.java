package lintcode.dynamicprogramming2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak2_LE_140_Perf_Opt {
    /*
        - similar to 139. follow 花花酱视频，重做一下，改善运行时间
        - https://www.youtube.com/watch?v=JqOIRBC0_9c
        - Time is O(N^2) - 看递归调用的数量
    */

    //using Map memory to optimize the performance
    Map<String, List<String>> mem = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {

        if (mem.containsKey(s)) {
            return mem.get(s);
        }

        List<String> result = new ArrayList<>();
        //if whole word is in the dictionary, add it to ans
        if (wordDict.contains(s)) {
            result.add(s);
        }

        for (int i = 1; i < s.length(); i++) {
            //if right part not in the dictionary then continue, improve time perf
            String right = s.substring(i);
            if (!wordDict.contains(right)) {
                continue;
            }

            //gets the answer for the left part
            String left = s.substring(0, i);
            List<String> left_result = append(wordBreak(left, wordDict), right);

            //notice cannot use mem here, since the ans for s is not settled yet
            for (String str : left_result) {
                result.add(str);
            }
        }
        mem.put(s, result);
        return mem.get(s);
    }

    private List<String> append(List<String> left, String right) {
        List<String> result = new ArrayList<>();
        for (String str : left) {
            result.add(str + " " + right);
        }
        return result;
    }

    public static void main(String[] args) {
        WordBreak2_LE_140_Perf_Opt solution = new WordBreak2_LE_140_Perf_Opt();

        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        //["cats and dog","cat sand dog"]
        System.out.println(solution.wordBreak(s, wordDict));
    }
}
