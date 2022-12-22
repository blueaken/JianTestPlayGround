package lintcode.trie.labuladong;

import util.TrieSet;

public class TrieImplementation_LE_208_Rec {
    // 直接封装 TrieSet
    TrieSet set;

    public TrieImplementation_LE_208_Rec() {
        set = new TrieSet();
    }

    public void insert(String word) {
        set.add(word);
    }

    public boolean search(String word) {
        return set.contains(word);
    }

    public boolean startsWith(String prefix) {
        return set.hasKeyWithPrefix(prefix);
    }

    public static void main(String[] args) {
        TrieImplementation_LE_208_Rec solution = new TrieImplementation_LE_208_Rec();
        solution.insert("apple");
        System.out.println(solution.search("apple")); //true
        System.out.println(solution.search("app")); //false
        System.out.println(solution.startsWith("app")); //true
        solution.insert("app");
        System.out.println(solution.search("app")); //true
    }

}
