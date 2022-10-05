package lintcode.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllConcatenatedWordsInADict_LE_472_Trie_AnotherWay_P2 {
    /*
        P1
        - note it is similar to 139 word break, but the diff is 472 does not count the small word, and 139 counts, so 472 cannot completely copy 139 solution, need to use Trie instead, so as to filter smaller word
        9.13.22 - another way of using Trie here is
        1. load all words into the Trie tree
        2. check each word along the Trie tree, if current prefix is a word, say 0 ~ i, then recursively check the substring i+1 ~ end, it is more efficient, Time is O(N), N is total characters of the words in the words dictionary
        ==========================================================
        P2
        10.5.2022
        - try 2 ways of using Trie
    */

    class Trie {
        Map<Character, Trie> children;
        boolean isEnd;

        Trie() {
            this.children = new HashMap<>();
        }

        private void insert(String str) {
            Trie node = this;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new Trie());
                }
                node = node.children.get(c);
            }
            node.isEnd = true;
        }
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        Trie dict = new Trie();
        for (String word : words){
            dict.insert(word);
        }

        List<String> res = new ArrayList<>();
        //process in the order of length by the algorithm nature
        for (String word : words){
            if (check(word, dict, 0, 0)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean check(String word, Trie dict, int start, int count) {
        Trie node = dict;
        for (int i = start; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
            if (node.isEnd) {
                if (i == word.length()-1) {
                    return count > 0; //filter the smallest words
                } else {
                    if (check(word, dict, i+1, count+1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FindAllConcatenatedWordsInADict_LE_472_Trie_AnotherWay_P2 solution = new FindAllConcatenatedWordsInADict_LE_472_Trie_AnotherWay_P2();
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        //expect ["catsdogcats","dogcatsdog","ratcatdogcat"]

        System.out.println(solution.findAllConcatenatedWordsInADict(words));
    }
}
