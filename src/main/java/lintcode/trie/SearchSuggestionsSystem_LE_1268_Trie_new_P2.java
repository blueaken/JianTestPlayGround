package lintcode.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    - new P1
    - ref prev code
    - using Trie, need to refresh the algorithm
    ========================================
    new P2 12.24.2022
    - refactor a little after 东哥 template
*/
public class SearchSuggestionsSystem_LE_1268_Trie_new_P2 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        //build Trie dictionary
        Trie root = new Trie();
        for (String s : products) {
            root.insert(s);
        }
        return root.getProductsFromKey(searchWord);
    }
}

class Trie {
    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEnd = false;;
    }

    TrieNode root;

    Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.isEnd = true;
    }

    public List<List<String>> getProductsFromKey(String key) {
        //search each chars of the search key
        String prefix = "";
        TrieNode node = root;

        List<List<String>> result = new ArrayList<>();
        List<String> buffer = new ArrayList<>();
        boolean isMatch = true;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            prefix += c;
            if (!node.children.containsKey(c)) {
                isMatch = false;
                result.add(buffer);
                continue;
            }
            if (isMatch) {
                node = node.children.get(c);
                dfs(node, prefix, buffer);
            }
            result.add(buffer);
            buffer = new ArrayList<>();
        }
        return result;
    }

    private void dfs(TrieNode node, String prefix, List<String> buffer) {
        if (buffer.size() == 3) {
            return;
        }

        if (node.isEnd) {
            buffer.add(prefix);
        }

        for (char c = 'a'; c <= 'z'; c++) {
            if (node.children.containsKey(c)) {
                dfs(node.children.get(c), prefix + c, buffer);
            }
        }
    }
}
