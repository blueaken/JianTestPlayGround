package lintcode.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchSuggestionsSystem_LE_1268_Trie_P1 {
    /*
        - Brute force is a good choice, because the length of string is less than 1000.
        - Time O(M*N), M - length of searchWord, N - length of products array
        - Trie + DFS - Trie usually fits for word prefix problems.
        - The question aks for a sorted result, and a preorder traversal of a trie always result in a sorted result. We need to limit the word traversal to 3 though.
        - Time - O(M) to build the Trie tree, where M is the number of chars in products. For each prefix search, O(len(prefix)) to find the representative Tire node, and dfs to find at most 3 words is O(1).
        - Space is O(26n) = O(n), n is the number of nodes in the Trie.
        - ref https://leetcode.com/problems/search-suggestions-system/solution/

        - refactor to remove the Node class and put Trie related function into Trie class itself as much as possible, have to expose startWith fun & dfs into the main class, so as to handle variable result buffer; now understand why the previous solution use a Node class inside Trie class, which encapsulates the variable result buffer and makes the main class as concise as possible
        - this solution fail in a corner case, visit later
        - bug fixed 6/11/2022, ACed
    */

    class Trie {
        private Map<Character, Trie> children;
        boolean isEnd;

        Trie () {
            children = new HashMap<>();
        }

        //O(m) - m is the number of chars of the products
        public void insert(String word) {
            Trie cur = this;
            for (char c : word.toCharArray()) {
                if (!cur.children.containsKey(c)) {
                    cur.children.put(c, new Trie());
                }
                cur = cur.children.get(c);
            }
            cur.isEnd = true;
        }

    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie root = new Trie();
        List<List<String>> result = new ArrayList<>();
        //add all words to trie.
        for (String w : products) {
            root.insert(w);
        }

        String prefix = new String();
        List<String> resultBuffer = new ArrayList<>();
        Trie node = root;
        boolean notMatch = false;
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            if (!node.children.containsKey(c)) {
                result.add(resultBuffer);
                notMatch = true;
                continue;
            }
            if (!notMatch) {
                node = node.children.get(c);
                dfs(node, prefix, resultBuffer);
            }
            result.add(resultBuffer);
            resultBuffer = new ArrayList<>();
        }
        return result;
    }

    private void dfs(Trie cur, String word, List<String> resultBuffer) {
        //bottom case
        if (resultBuffer.size() == 3) {
            return;
        }
        if (cur.isEnd) {
            resultBuffer.add(word);
        }

        //dfs on all possible path, in lexicographical order
        for (char c = 'a'; c <= 'z'; c++) {
            if (cur.children.containsKey(c)) {
                dfs(cur.children.get(c), word + c, resultBuffer);
            }
        }
        return;
    }

    public static void main(String[] args) {
        SearchSuggestionsSystem_LE_1268_Trie_P1 solution = new SearchSuggestionsSystem_LE_1268_Trie_P1();
//        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
//        String searchWord = "mouse";
////        [
//        //["mobile","moneypot","monitor"],
//        //["mobile","moneypot","monitor"],
//        //["mouse","mousepad"],
//        //["mouse","mousepad"],
//        //["mouse","mousepad"]
////]

        String[] products = {"abcde","nun","nurse"};
        String searchWord = "nquno";
//[["nun","nurse"],[],[],[],[]]

        System.out.println(solution.suggestedProducts(products, searchWord).toString());
    }
}
