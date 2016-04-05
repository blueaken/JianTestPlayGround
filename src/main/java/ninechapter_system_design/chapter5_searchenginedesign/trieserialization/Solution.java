package ninechapter_system_design.chapter5_searchenginedesign.trieserialization;

import type.system_design.TrieNode1;

import java.util.Set;
import java.util.Stack;

/**
 * Author: blueaken
 * Date: 4/4/16 9:03 AM
 */
public class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a trie which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public static String serialize(TrieNode1 root) {
        // Write your code here
        if (root == null) {
            return null;
        }

        //dfs
        StringBuilder sb = new StringBuilder();
        rec(root, sb, 0);
        return sb.toString();
    }

    //level is not used anywhere, but keep it here for practice purpose
    private static void rec(TrieNode1 node, StringBuilder sb, int level) {
        if (node.children == null || node.children.keySet() == null) {
            return;
        }

        Set<Character> keySet = node.children.keySet();
        sb.append("<");
        for (Character c : keySet) {
            sb.append(c);
            rec(node.children.get(c), sb, level+1);
        }
        sb.append(">");
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

        Stack<TrieNode1> stack = new Stack<>();
        TrieNode1 root = new TrieNode1();
        TrieNode1 node = root;
//        for (int i = 0; i < data.length(); i++) {
//            Character c = data.charAt(i);
////            stack.peek();
//            if (c != '|' && !node.children.containsKey(c)){
//                node.children.put(c, new TrieNode1());
//            }
//            node = node.children.get(c);
//        }

        for (Character c : data.toCharArray()) {
            switch (c) {
                case '<':
                    stack.push(node);
                    break;
                case '>':
                    stack.pop();
                    break;
                default:
                    node = new TrieNode1();
                    stack.peek().children.put(c, node);
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
