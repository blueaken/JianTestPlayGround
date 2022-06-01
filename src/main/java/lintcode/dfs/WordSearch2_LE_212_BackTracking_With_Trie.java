package lintcode.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class WordSearch2_LE_212_BackTracking_With_Trie {
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

        Trie () {
            children = new HashMap<>();
            word = null;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {

        //build the Trie, Time - O(M * L), M - the number of words, L - the longest length of word
        Trie root = new Trie();
        for (String word : words) {
            Trie node = root;
            for (char c : word.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new Trie());
                }
                node = node.children.get(c);
            }
            node.word = word;
        }

        //backtracking each cell of the board, Time - O(N * 3 ^ (L - 1)), N - the number of cells of the board, L - the longest length of word
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.children.containsKey(board[i][j])) {
                    backtracking(i, j, root, board, res);
                }
            }
        }
        return res;
    }

    private void backtracking(int i, int j, Trie node, char[][] board, List<String> res) {
        char letter = board[i][j];
        Trie curNode = node.children.get(letter);

        if (curNode.word != null) {
            res.add(curNode.word);
            curNode.word = null; //in case duplicate
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        board[i][j] = '#'; //mark as visited
        for (int k = 0; k < 4; k++) {
            int newRow = i + dx[k];
            int newCol = j + dy[k];
            if (newRow < 0 || newRow == board.length || newCol < 0 || newCol == board[0].length) {
                continue;
            }
            if (curNode.children.containsKey(board[newRow][newCol])) {
                backtracking(newRow, newCol, curNode, board, res);
            }
        }
        board[i][j] = letter;//always backtracking, not matter found or not for next search
    }

    public static void main(String[] args) {
        WordSearch2_LE_212_BackTracking_With_Trie solution = new WordSearch2_LE_212_BackTracking_With_Trie();
//        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
//        String[] words = {"oath","pea","eat","rain"};
//        //["eat","oath"]

        char[][] board = {{'o','a','b','n'},{'o','t','a','e'},{'a','h','k','r'},{'a','f','l','v'}};
        String[] words = {"oa","oaa"};
        //["oa","oaa"]

        System.out.println(solution.findWords(board, words));
    }
}
