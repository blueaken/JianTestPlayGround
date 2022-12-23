package lintcode.trie;

import java.util.HashMap;
import java.util.Map;

/**
 12.23.2022
 - refactor and try to make it as a template just like 东哥 did
 */
public class TrieImplementation_LE_208_P1_Template {
    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEnd = false;
    }

    // Trie 树的根节点
    TrieNode root;

    public TrieImplementation_LE_208_P1_Template() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!curNode.children.containsKey(c)) {
                curNode.children.put(c, new TrieNode());
            }
            curNode = curNode.children.get(c);
        }
        curNode.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode curNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!curNode.children.containsKey(c)) {
                return false;
            }
            curNode = curNode.children.get(c);
        }
        return curNode.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!curNode.children.containsKey(c)) {
                return false;
            }
            curNode = curNode.children.get(c);
        }
        return true;
    }
}
