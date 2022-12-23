package lintcode.trie;

import util.trie.Trie;

import java.util.ArrayList;
import java.util.List;

public class FindAllConcatenatedWordsInADict_LE_472_Trie_AnotherWay_P3 {
    /*
        P1
        - note it is similar to 139 word break, but the diff is 472 does not count the small word, and 139 counts, so 472 cannot completely copy 139 solution, need to use Trie instead, so as to filter smaller word
        9.13.22 - another way of using Trie here is
        1. load all words into the Trie tree
        2. check each word along the Trie tree, if current prefix is a word, say 0 ~ i, then recursively check the substring i+1 ~ end, it is more efficient, Time is O(N), N is total characters of the words in the words dictionary
        ==========================================================
        P2
        10.5.2022
        - try 2 ways of using Trie
        ==========================================================
        P3 12.23.2022
        - try with mine own template
    */

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        Trie dict = new Trie();
        for (String word : words){
            dict.insert(word);
        }

        List<String> res = new ArrayList<>();
        //process in the order of length by the algorithm nature
        for (String word : words){
            if (dict.checkIfConcatenatedWords(word, 0, 0)) {
                res.add(word);
            }
        }
        return res;
    }
}
