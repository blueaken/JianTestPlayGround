package ninechapter_algorithm.chapter9_graphic.optional.surroundedregions;

/**
 * Author: blueaken
 * Date: 6/16/16 19:16
 */
public class Solution_DFS {
    /**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
    public void surroundedRegions(char[][] board) {
        // Write your code here
        if (board == null || board.length == 0 ||
                board[0] == null || board[0].length == 0) {
            return;
        }

        //1. fill Os on the board to #s
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                flipRegionBorder(board, i, 0, 'O', '#');
            }
            if (board[i][board[0].length - 1] == 'O') {
                flipRegionBorder(board, i, board[0].length - 1, 'O', '#');
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                flipRegionBorder(board, 0, i, 'O', '#');
            }
            if (board[board.length - 1][i] == 'O') {
                flipRegionBorder(board, board.length - 1, i, 'O', '#');
            }
        }

        //2. scan the area
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }

        return;
    }

    private void flipRegionBorder(char[][] board, int i, int j, char from, char to) {
        if (i < 0 || i == board.length || j < 0 || j == board[0].length
                || board[i][j] != from) {
            return;
        }
        board[i][j] = to;
        flipRegionBorder(board, i - 1, j, from, to);
        flipRegionBorder(board, i + 1, j, from, to);
        flipRegionBorder(board, i, j - 1, from, to);
        flipRegionBorder(board, i, j + 1, from, to);

        return;
    }

    public static void main(String[] args) {
        Solution_DFS solution = new Solution_DFS();
        char board[][] = {
                { 'X', 'X', 'X', 'X'},
                { 'X', 'O', 'O', 'X'},
                { 'X', 'X', 'O', 'X'},
                { 'X', 'O', 'X', 'X'}
        };
        solution.surroundedRegions(board);
    }
}
