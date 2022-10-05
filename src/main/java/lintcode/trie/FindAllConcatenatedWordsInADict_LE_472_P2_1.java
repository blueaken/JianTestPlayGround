package lintcode.trie;

import java.util.*;

public class FindAllConcatenatedWordsInADict_LE_472_P2_1 {
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

        private boolean contains(String prefix) {
            Trie node = this;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (!node.children.containsKey(c)) {
                    return false;
                }
                node = node.children.get(c);
            }
            return node.isEnd;
        }
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Trie dict = new Trie();

        List<String> res = new ArrayList<>();
        for (String word : words){
            if (check(word, dict)) {
                res.add(word);
            }
            dict.insert(word);
        }
        return res;
    }

    private boolean check(String word, Trie dict) {
        if (dict.children.size() == 0) {
            return false;
        }
        if (dict.contains(word)) {
            return true;
        }

        for (int i = 1; i < word.length(); i++) {
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
}
