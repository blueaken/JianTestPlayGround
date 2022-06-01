package lintcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2_LE_212_BackTracking {
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
        for (int n = 0; n < words.length; n++) {
            for (int i = 0; i < board.length; i++) {
                if (!found[n]) {
                    for (int j = 0; j < board[0].length; j++) {
                        if (backtracking(i, j, 0, words[n], board)) {
                            found[n] = true;
                            res.add(words[n]);
                            break;
                        }
                    }
                } else {
                    break;
                }
            }
        }
        return res;
    }

    private boolean backtracking(int i, int j, int pos, String word, char[][] board) {
        if (pos == word.length()) {
            return true;
        }

        if (i < 0 || i == board.length || j < 0 || j == board[0].length
                || board[i][j] != word.charAt(pos)) {
            return false;
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        board[i][j] = '#'; //mark as visited
        boolean ret = false;
        for (int k = 0; k < 4; k++) {
            ret = backtracking(i + dx[k], j + dy[k], pos + 1, word, board);
            if (ret) {
                break;
            }
        }
        board[i][j] = word.charAt(pos);//always backtracking, not matter found or not for next search
        return ret;
    }

    public static void main(String[] args) {
        WordSearch2_LE_212_BackTracking solution = new WordSearch2_LE_212_BackTracking();
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};

        System.out.println(solution.findWords(board, words));
    }
}
