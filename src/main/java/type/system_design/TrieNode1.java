package type.system_design;

import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Author: blueaken
 * Date: 4/4/16 9:02 AM
 */
public class TrieNode1 {
    public NavigableMap<Character, TrieNode1> children;
    public boolean hasWord;
    public TrieNode1() {
        children = new TreeMap<>();
        hasWord = false;
    }
}
