package lintcode.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchSuggestionsSystem_LE_1268_Trie_new_P1 {
    /*
        - new P1
        - ref prev code
        - using Trie, need to refresh the algorithm
    */

    class Trie {
        Map<Character, Trie> children;
        boolean isEnd;

        Trie() {
            this.children = new HashMap<>();
        }

        private void insert(String word) {
            Trie cur = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!cur.children.containsKey(c)) {
                    cur.children.put(c, new Trie());
                }
                cur = cur.children.get(c);
            }
            cur.isEnd = true;
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        //build Trie dictionary
        Trie root = new Trie();
        for (String s : products) {
            root.insert(s);
        }

        //search each chars of the search word
        String prefix = "";
        Trie node = root;
        List<List<String>> result = new ArrayList<>();
        List<String> buffer = new ArrayList<>();
        boolean isMatch = true; //default flag to match
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            if (!node.children.containsKey(c)) {
                isMatch = false;
                result.add(buffer);
                continue;
            }
            //dfs if there is match on the Trie dictionary
            if (isMatch) {
                node = node.children.get(c);
                dfs(node, prefix, buffer);
            }
            result.add(buffer);
            buffer = new ArrayList<>();
        }
        return result;
    }

    private void dfs(Trie node, String prefix, List<String> buffer) {
        if (buffer.size() == 3) {
            return;
        }

        if (node.isEnd) {
            buffer.add(prefix);
        }

        //dfs on all possible paths, in lexicographical order
        for (char c = 'a'; c <= 'z'; c++) {
            if (node.children.containsKey(c)) {
                dfs(node.children.get(c), prefix + c, buffer);
            }
        }
    }
}
