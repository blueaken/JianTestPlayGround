package lintcode.trie;

import java.util.Map;
import java.util.HashMap;

/*
    - why not Hash table Or balanced Tree?
    - There are several other data structures, like balanced trees and hash tables, which give us the possibility to search for a word in a dataset of strings. Then why do we need trie? Although hash table has O(1) time complexity for looking for a key, it is not efficient in the following operations :

    1. Finding all keys with a common prefix.
    2. Enumerating a dataset of strings in lexicographical order.

    - Another reason why trie outperforms hash table, is that as hash table increases in size, there are lots of hash collisions and the search time complexity could deteriorate to O(n), where n is the number of keys inserted. Trie could use less space compared to Hash Table when storing many keys with the same prefix. In this case using trie has only O(m) time complexity, where m is the key length. Searching for a key in a balanced tree costs O(mlogn) time complexity.
*/
public class TrieImplementation_LE_208 {
    Map<Character, TrieImplementation_LE_208> children;
    boolean isEnd;

    public TrieImplementation_LE_208() {
        children = new HashMap<>();
        isEnd = false;
    }

    /*
        Time is O(m), m - is the length of word
        Space is O(m), in worst case, it requires adding m new Nodes
    */
    public void insert(String word) {
        TrieImplementation_LE_208 curNode = this;
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if (!curNode.children.containsKey(cur)){
                curNode.children.put(cur, new TrieImplementation_LE_208());
            }
            curNode = curNode.children.get(cur);
        }
        curNode.isEnd = true;
    }

    /*
        Time is O(m), Space is O(1)
    */
    public boolean search(String word) {
        TrieImplementation_LE_208 curNode = this;
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if (!curNode.children.containsKey(cur)){
                return false;
            }
            curNode = curNode.children.get(cur);
        }
        return curNode.isEnd;
    }

    /*
        Time is O(m), Space is O(1)
    */
    public boolean startsWith(String prefix) {
        TrieImplementation_LE_208 curNode = this;
        for (int i = 0; i < prefix.length(); i++) {
            char cur = prefix.charAt(i);
            if (!curNode.children.containsKey(cur)){
                return false;
            }
            curNode = curNode.children.get(cur);
        }
        return true;
    }
}
