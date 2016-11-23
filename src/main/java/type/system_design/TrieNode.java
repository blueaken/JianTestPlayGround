package type.system_design;

import java.util.HashMap;

/**
 * Author: blueaken
 * Date: 4/3/16 10:24 PM
 */
public class TrieNode {
    // Initialize your data structure here.
    public HashMap<Character, TrieNode> children;
    public boolean hasWord;

    // Initialize your data structure here.
    public TrieNode() {
        children = new HashMap<>();
        hasWord = false;
    }
}
