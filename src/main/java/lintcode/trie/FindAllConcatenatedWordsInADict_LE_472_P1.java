package lintcode.trie;

import java.util.*;

public class FindAllConcatenatedWordsInADict_LE_472_P1 {
    /*
        P1
        - note it is similar to 139 word break, but the diff is 472 does not count the small word, and 139 counts, so 472 cannot completely copy 139 solution, need to use Trie instead, so as to filter smaller word
        9.13.22 - another way of using Trie here is
        1. load all words into the Trie tree
        2. check each word along the Trie tree, if current prefix is a word, say 0 ~ i, then recursively check the substring i+1 ~ end, should be more time efficient.
    */

    class Trie {
        Map<Character, Trie> children;
        boolean isEnd;

        Trie() {
            children = new HashMap<>();
        }

        private void insert(String word) {
            Trie node = this;
            for (char c : word.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new Trie());
                }
                node = node.children.get(c);
            }
            node.isEnd = true;
        }

        private boolean contains(String word) {
            Trie node = this;
            for (char c : word.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    return false;
                }
                node = node.children.get(c);
            }
            return node.isEnd;
        }
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        List<String> res = new ArrayList<>();
        Trie dict = new Trie();

        //have to process in the order of length
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        for (String word : words) {
            if (check(word, dict)) {
                res.add(word);
            }
            dict.insert(word);
        }
        return res;
    }

    private boolean check(String word, Trie dict) {
        // precheck for performance
        if (dict.children.size() == 0) {
            return false;
        }

        if (dict.contains(word)) {
            return true;
        }

        for (int i = 1; i < word.length(); i++) {
            //process right first for performance
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
        FindAllConcatenatedWordsInADict_LE_472_P1 solution = new FindAllConcatenatedWordsInADict_LE_472_P1();
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        //expect ["catsdogcats","dogcatsdog","ratcatdogcat"]

        System.out.println(solution.findAllConcatenatedWordsInADict(words));
    }
}
