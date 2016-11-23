package ninechapter_algorithm.chapter9_graphic.optional.surroundedregions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: blueaken
 * Date: 6/17/16 09:50
 */
public class Solution_BFS_NO_Node_Class {

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
            flipRegionBorder(board, i, 0, 'O', '#');
            flipRegionBorder(board, i, board[0].length - 1, 'O', '#');
        }
        for (int i = 0; i < board[0].length; i++) {
            flipRegionBorder(board, 0, i, 'O', '#');
            flipRegionBorder(board, board.length - 1, i, 'O', '#');
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

        if(board[i][j] != from) {
            return;
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int code = i * board[0].length + j;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(code);
        while (queue.size() > 0) {
            code = queue.poll();
            //board[0].length cannot be 0, while board.length can
            int row = code / board[0].length;
            int col = code % board[0].length;
            board[row][col] = to;
            for (int m = 0; m < dx.length; m++) {
                int x = row + dx[m];
                int y = col + dy[m];
                if (x >= 0 && x < board.length && y >= 0 && y < board[0].length
                        && board[x][y] == from) {
                    queue.offer(x * board[0].length + y);
                }
            }
        }

        return;
    }

    public static void main(String[] args) {
        Solution_BFS_NO_Node_Class solution = new Solution_BFS_NO_Node_Class();
        char board[][] = {
                { 'X', 'O', 'X', 'X'},
                { 'O', 'X', 'O', 'X'},
                { 'X', 'O', 'X', 'O'},
                { 'O', 'X', 'O', 'X'},
                { 'X', 'O', 'X', 'O'},
                { 'O', 'X', 'O', 'X'}
        };
        solution.surroundedRegions(board);
    }
}
