package ninechapter_system_design.chapter5_searchenginedesign.implementtrie;

import type.system_design.TrieNode;

/**
 * Author: blueaken
 * Date: 4/3/16 10:25 PM
 */
public class Solution {
    private TrieNode root;

    public Solution() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode now = root;
        for(int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (!now.children.containsKey(c)) {
                now.children.put(c, new TrieNode());
            }
            now = now.children.get(c);
        }
        now.hasWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode now = root;
        for(int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (!now.children.containsKey(c)) {
                return false;
            }
            now = now.children.get(c);
        }
        return now.hasWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode now = root;
        for (int i = 0; i < prefix.length(); i++) {
            Character c = prefix.charAt(i);
            if (!now.children.containsKey(c)) {
                return false;
            }
            now = now.children.get(c);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.insert("lintcode");
        solution.search("lint");
        solution.startsWith("lint");
    }
}
