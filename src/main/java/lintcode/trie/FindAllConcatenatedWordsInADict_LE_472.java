package lintcode.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class FindAllConcatenatedWordsInADict_LE_472 {
    /*
        - similar to word break 139/140, 字典树 + DFS, DFS通过记忆化优化
        - ref https://www.youtube.com/watch?v=dsnTJscs4BA
    */

    class Trie {
        Map<Character, Trie> children;
        boolean isEnd;

        Trie () {
            children = new HashMap<>();
            isEnd = false;
        }

        //O(m) - m is number of chars of the word
        public void insert(String word) {
            Trie cur = this;
            for (char c : word.toCharArray()) {
                if (!cur.children.containsKey(c)) {
                    cur.children.put(c, new Trie());
                }
                cur = cur.children.get(c);
            }
            cur.isEnd = true;
        }

        public boolean contains(String word) {
            Trie cur = this;
            for (char c : word.toCharArray()) {
                if (!cur.children.containsKey(c)) {
                    return false;
                }
                cur = cur.children.get(c);
            }
            return cur.isEnd;
        }
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie dict = new Trie();
        List<String> res = new ArrayList<>();

        //根据长度来构造字典树，避免字典树的重复构造
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for (String w : words) {
            if (check(w, dict)) {
                //if w can be consists of words from dictionary, which is basically a LE 139 quesiton, then add to the result
                res.add(w);
            }
            //after check, add the current word into the dictionary
            dict.insert(w);
        }
        return res;
    }

    private boolean check(String word, Trie dict) {
        if (dict == null) {
            return false;
        }

        //if whole word is in the dictionary, return true
        if (dict.contains(word)) {
            return true;
        }

        for (int i = 1; i < word.length(); i++) {
            //if right part is not in the dictionary, continue immediately - improve perf
            String right = word.substring(i);
            if (!dict.contains(right)) {
                continue;
            }

            String left = word.substring(0, i);
            if (check(left, dict)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FindAllConcatenatedWordsInADict_LE_472 solution = new FindAllConcatenatedWordsInADict_LE_472();
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        //expect ["catsdogcats","dogcatsdog","ratcatdogcat"]

        System.out.println(solution.findAllConcatenatedWordsInADict(words));

        //this version is DFS without memorization, time is 182 ms, beat 13%,
        //found it is hard to using memorization like 139 in this problem, since the way dfs function (check) is called
    }
}
