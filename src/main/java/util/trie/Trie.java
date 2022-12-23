package util.trie;

import java.util.HashMap;
import java.util.Map;

/**
 12.23.2022
 - refactor LE 208 and try making as a template following 东哥's
 */
public class Trie {
    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEnd = false;
    }

    // Trie 树的根节点
    TrieNode root;

    public Trie() {
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

    public boolean contains(String word) {
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

    // for LE_472
    public boolean checkIfSubStrExistsAndCount(String str, int startPos, int count) {
        TrieNode node = root;
        for (int i = startPos; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
            if (node.isEnd) {
                if (i == str.length()-1) {
                    return count > 0; //filer out the smallest word
                } else {
                    if (checkIfSubStrExistsAndCount(str, i+1, count+1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
