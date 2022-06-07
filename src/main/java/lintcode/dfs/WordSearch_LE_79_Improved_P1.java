package lintcode.dfs;

public class WordSearch_LE_79_Improved_P1 {
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
                if (backtracking(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[][] board, int row, int col, int pos, String word) {
        if (pos == word.length()) {
            return true;
        }

        if (row < 0 || row == board.length || col < 0 || col == board[0].length || board[row][col] != word.charAt(pos)) {
            return false;
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        board[row][col] = '#'; //mark as visited
        for (int i = 0; i < 4; i++) {
            if (backtracking(board, row + dx[i], col + dy[i], pos + 1, word)) {
                return true;
            }
        }
        board[row][col] = word.charAt(pos);
        return false;
    }

    public static void main(String[] args) {
        WordSearch_LE_79_Improved_P1 solution = new WordSearch_LE_79_Improved_P1();
        char[][] board = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        String word = "AAB";
        //true

//        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','F'}};
//        String word = "ABCCED";
//        //true

        System.out.println(solution.exist(board, word));
    }
}
