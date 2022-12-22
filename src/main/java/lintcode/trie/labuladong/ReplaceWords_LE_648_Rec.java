package lintcode.trie.labuladong;

import util.TrieSet;

import java.util.List;

public class ReplaceWords_LE_648_Rec {
    /**
     12.22.2022
     ref 东哥 Trie template only，since different than mine template
     */
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieSet trie = new TrieSet();
        for (String str : dictionary) {
            trie.add(str);
        }

        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String root = trie.shortestPrefixOf(words[i]);
            if (root.isEmpty()) {
                sb.append(words[i]);
            } else {
                sb.append(root);
            }

            if (i != words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
