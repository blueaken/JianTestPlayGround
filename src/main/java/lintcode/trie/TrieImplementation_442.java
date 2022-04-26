package lintcode.trie;

import java.util.HashMap;

/*
    Ref - https://www.youtube.com/watch?v=AXjmTQ8LEoI
 */
public class TrieImplementation_442 {
    private HashMap<Character, TrieImplementation_442> children;
    private boolean isEnd;

    public TrieImplementation_442() {
        // do intialization if necessary
        children = new HashMap<>();
        isEnd = false;
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        // write your code here
        int len = word.length();
        TrieImplementation_442 curNode = this;
        for (int i = 0; i < len; i++) {
            char cur = word.charAt(i);
            if (curNode.children.get(cur) == null) {
                TrieImplementation_442 newNode = new TrieImplementation_442();
                curNode.children.put(cur, newNode);
            }
            curNode = curNode.children.get(cur);
        }
        curNode.isEnd = true;
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        // write your code here
        int len = word.length();
        TrieImplementation_442 curNode = this;
        for (int i = 0; i < len; i++) {
            char cur = word.charAt(i);
            if (curNode.children.get(cur) == null) {
                return false;
            }
            curNode = curNode.children.get(cur);
        }
        return curNode.isEnd;
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        // write your code here
        int len = prefix.length();
        TrieImplementation_442 curNode = this;
        for (int i = 0; i < len; i++) {
            char cur = prefix.charAt(i);
            if (curNode.children.get(cur) == null) {
                return false;
            }
            curNode = curNode.children.get(cur);
        }
        return true;
    }
}
