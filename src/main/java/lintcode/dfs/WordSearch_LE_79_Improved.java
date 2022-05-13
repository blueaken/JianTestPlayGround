package lintcode.dfs;

public class WordSearch_LE_79_Improved {
    /*
        Modified my BackTrack solution Ref - https://leetcode.com/problems/word-search/solution/
        Good learned from the ref link to make backtrack dfs more elegant:
        1. check the boundaries before explore instead of doing it one by one
        2. explore the dfs with rowOffsets & colOffersets array
        3. use '#' mark on the original array to indicate visited, instead of a standalone visited array

        Time is O(N * 3^L), N is the number of cells in the board and L is the length of word to be matched. For each cell, we explore 3 directions (we won't go back to where we come).
        Space is O(L), which is used on the call stack of recursion, L is the length of word to be matched.
    */
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(i, j, word, 0, board)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(int row, int col, String word, int pos, char[][] board) {
        //step 1. check bottom case
        if (pos == word.length()) {
            return true;
        }

        //step 2. check the boundaries & cur position validation
        if (row < 0 || row == board.length || col < 0 || col == board[0].length
                || board[row][col] != word.charAt(pos)) {
            return false;
        }

        //step 3. explore the 4 directions and return result
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        board[row][col] = '#';
        for (int i = 0; i < 4; i++) {
            if (backtrack(row + dx[i], col + dy[i], word, pos + 1, board)) {
                return true;
            }
        }
        board[row][col] = word.charAt(pos);
        return false;
    }

    public static void main(String[] args) {
        WordSearch_LE_79_Improved solution = new WordSearch_LE_79_Improved();
        char[][] board = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        String word = "AAB";
        //true

        System.out.println(solution.exist(board, word));
    }
}
