package ninechapter_system_design.chapter5_searchenginedesign.trieserialization;

import type.system_design.TrieNode1;

import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

/**
 * Author: blueaken
 * Date: 4/4/16 10:48 PM
 */
public class Solution_ninechapter {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a trie which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public static String serialize(TrieNode1 root) {
        // Write your code here
        if (root == null)
            return "";

        StringBuffer sb = new StringBuffer();
        sb.append("<");
        Iterator iter = root.children.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry)iter.next();
            Character key = (Character)entry.getKey();
            TrieNode1 child = (TrieNode1)entry.getValue();
            sb.append(key);
            sb.append(serialize(child));
        }
        sb.append(">");
        return sb.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public static TrieNode1 deserialize(String data) {
        // Write your code here
        if (data == null || data.length() == 0)
            return null;

        TrieNode1 root = new TrieNode1();
        TrieNode1 current = root;
        Stack<TrieNode1> path = new Stack<>();
        for (Character c : data.toCharArray()) {
            switch (c) {
                case '<':
                    path.push(current);
                    break;
                case '>':
                    path.pop();
                    break;
                default:
                    current = new TrieNode1();
                    path.peek().children.put(c, current);
            }
        }
        return root;
    }

    // Inserts a word into the trie.
    public static void insert(TrieNode1 root, String word) {
        TrieNode1 now = root;
        for(int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (!now.children.containsKey(c)) {
                now.children.put(c, new TrieNode1());
            }
            now = now.children.get(c);
        }
        now.hasWord = true;
    }

    public static void main(String[] args) {
        TrieNode1 root = new TrieNode1();
        insert(root, "abc");
        insert(root, "ade");
//        insert(root, "rst");
//        insert(root, "ruv");

        System.out.println(serialize(root));
        deserialize(serialize(root));
    }
}
