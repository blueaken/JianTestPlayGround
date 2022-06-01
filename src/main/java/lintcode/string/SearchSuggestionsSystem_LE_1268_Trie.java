package lintcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchSuggestionsSystem_LE_1268_Trie {
    /*
        - Brute force is a good choice, because the length of string is less than 1000.
        - Time O(M*N), M - length of searchWord, N - length of products array
        - Trie + DFS - Trie usually fits for word prefix problems.
        - The question aks for a sorted result, and a preorder traversal of a trie always result in a sorted result. We need to limit the word traversal to 3 though.
        - Time - O(M) to build the Trie tree, where M is the number of chars in products. For each prefix search, O(len(prefix)) to find the representative Tire node, and dfs to find at most 3 words is O(1).
        - Space is O(26n) = O(n), n is the number of nodes in the Trie.
        - ref https://leetcode.com/problems/search-suggestions-system/solution/
    */
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        List<List<String>> result = new ArrayList<>();
        //add all words to trie.
        for (String w : products) {
            trie.insert(w);
        }
        String prefix = new String();
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            result.add(trie.getWordsStartsWith(prefix));
        }

        return result;
    }

    class Trie {
        class Node {
//            private Node[] children = new Node[26];
            private Map<Character, Node> children = new HashMap<>();
            boolean isEnd = false;
        };
        Node root, cur;
        List<String> resultBuffer;

        Trie() {
            this.root = new Node();
        }

        //O(m) - m is the number of chars of the products
        public void insert(String word) {
            cur = this.root;
            for (char c : word.toCharArray()) {
                if (!cur.children.containsKey(c)) {
                    cur.children.put(c, new Node());
                }
                cur = cur.children.get(c);
            }
            cur.isEnd = true;
        }

        public List<String> getWordsStartsWith(String prefix) {
            cur = this.root;
            this.resultBuffer = new ArrayList<>();
            for (char c : prefix.toCharArray()) {
                if (!cur.children.containsKey(c)) {
                    return this.resultBuffer;
                }
                cur = cur.children.get(c);
            }
            //prefix exists, dfs return all the words start with it in the resultBuffer, limit the size to 3
            dfs(cur, prefix);
            return this.resultBuffer;
        }

        public void dfs(Node cur, String word) {
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
                    dfs(cur.children.get(c), word + c);
                }
            }

        }

        /*
            for fun - not related to the problem
         */
        public boolean search(String word) {
            cur = this.root;
            for (char c : word.toCharArray()) {
                if (!cur.children.containsKey(c)) {
                    return false;
                }
                cur = cur.children.get(c);
            }
            return cur.isEnd;
        }

    }

    public static void main(String[] args) {
        SearchSuggestionsSystem_LE_1268_Trie solution = new SearchSuggestionsSystem_LE_1268_Trie();
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
//        [
        //["mobile","moneypot","monitor"],
        //["mobile","moneypot","monitor"],
        //["mouse","mousepad"],
        //["mouse","mousepad"],
        //["mouse","mousepad"]
//]

        System.out.println(solution.suggestedProducts(products, searchWord).toString());

    }
}
