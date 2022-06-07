package lintcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2_LE_212_BackTracking_P1 {
    /*
        - gut feeling, dfs(backtracking), similar to word search I
        - Time is O(M * N * 3^L), M is the number of words, N is the number of cells on the board, L is the average length of the words and get TLE with no surprise
        - note backtracking is a form of dfs, dfs does not always record visited path

        ref
        - https://www.guru99.com/difference-between-bfs-and-dfs.html#:~:text=BFS%20finds%20the%20shortest%20path%20to%20the%20destination,keep%20track%20of%20the%20next%20location%20to%20visit.
        - https://leetcode.com/discuss/general-discussion/649594/is-backtracking-and-dfs-same
    */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        boolean[] found = new boolean[words.length];
        for (int k = 0; k < words.length; k++) {
            for (int i = 0; i < board.length; i++) {
                if (found[k]) {
                    break;
                }
                for (int j = 0; j < board[0].length; j++) {
                    if (dfs(board, i, j, 0, words[k])) {
                        res.add(words[k]);
                        found[k] = true;
                        break;
                    }
                }
            }
        }
        return res;
    }

    private boolean dfs(char[][] board, int row, int col, int pos, String word) {
        if (pos == word.length()) {
            return true;
        }

        if (row < 0 || row == board.length || col < 0 || col == board[0].length || board[row][col] != word.charAt(pos)) {
            return false;
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        board[row][col] = '#';
        boolean ret = false;
        for (int i = 0; i < 4; i++) {
            ret = dfs(board, row + dx[i], col + dy[i], pos + 1, word);
            if (ret) {
                break;
            }
        }
        board[row][col] = word.charAt(pos);
        return ret;
    }

    public static void main(String[] args) {
        WordSearch2_LE_212_BackTracking_P1 solution = new WordSearch2_LE_212_BackTracking_P1();

        //        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
//        String[] words = {"oath","pea","eat","rain"};
//        //[oath, eat]

        char[][] board = {{'o','a','b','n'},{'o','t','a','e'},{'a','h','k','r'},{'a','f','l','v'}};
        String[] words = {"oa","oaa"};
        //[oa, oaa]

        System.out.println(solution.findWords(board, words));
    }
}
