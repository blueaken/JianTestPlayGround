package lintcode.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearch2_LE_212_BackTracking_With_Trie_P1 {
    /*
        - gut feeling, dfs(backtracking), similar to word search I
        - Time is O(M * N * 3^L), M is the number of words, N is the number of cells on the board, L is the average length of the words and get TLE with no surprise
        - note backtracking is a form of dfs, dfs does not always record visited path

        ref
        - https://www.guru99.com/difference-between-bfs-and-dfs.html#:~:text=BFS%20finds%20the%20shortest%20path%20to%20the%20destination,keep%20track%20of%20the%20next%20location%20to%20visit.
        - https://leetcode.com/discuss/general-discussion/649594/is-backtracking-and-dfs-same

        - ref the solution link of the trie solution
        - Intuitively, one might resort to the hashset data structure, this could work.
        - However, during the backtracking process, one would encounter more often the need to tell if there exists any word that contains certain prefix, rather than if a string exists as a word in the dictionary. Because if we know that there does not exist any match of word in the dictionary for a given prefix, then we would not need to further explore certain direction. And this, would greatly reduce the exploration space, therefore improve the performance of the backtracking algorithm.
        - this algorithm could be optimized to gradually remove leaf nodes after each visit
        - space is O(K), K - the number of total letters in the dictionary, in case we optimized with storing word in the Trie, we might need 2K space.
    */
    class Trie {
        Map<Character, Trie> children;
        String word;

        Trie() {
            children = new HashMap<>();
            word = null;
        }

        public void insert(String s) {
            Trie node = this;
            for (int i = 0; i < s.length(); i++) {
                if (!node.children.containsKey(s.charAt(i))) {
                    node.children.put(s.charAt(i), new Trie());
                }
                node = node.children.get(s.charAt(i));
            }
            node.word = s;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        //build the Trie, Time - O(K), K - the number of total letters in the dictionary
        Trie root = new Trie();
        for (String word : words) {
            root.insert(word);
        }

        //backtracking each cell of the board, Time - O(N * 3 ^ (L - 1)), N - the number of cells of the board, L - the longest length of word
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.children.containsKey(board[i][j])) {
                    dfs(board, i, j, root, res);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] board, int row, int col, Trie node, List<String> res) {
        if (row < 0 || row == board.length || col < 0 || col == board[0].length || !node.children.containsKey(board[row][col])) {
            return;
        }

        char curLetter = board[row][col];
        Trie cur = node.children.get(curLetter);
        if (cur.word != null) {
            res.add(cur.word);
            cur.word = null; //in case duplicate
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        board[row][col] = '#';
        for (int i = 0; i < 4; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            dfs(board, newRow, newCol, cur, res);
        }
        board[row][col] = curLetter;
    }

    public static void main(String[] args) {
        WordSearch2_LE_212_BackTracking_With_Trie_P1 solution = new WordSearch2_LE_212_BackTracking_With_Trie_P1();

//        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
//        String[] words = {"oath","pea","eat","rain"};
//        //[oath, eat]

        char[][] board = {{'o','a','b','n'},{'o','t','a','e'},{'a','h','k','r'},{'a','f','l','v'}};
        String[] words = {"oa","oaa"};
        //[oa, oaa]

        System.out.println(solution.findWords(board, words));
    }
}
