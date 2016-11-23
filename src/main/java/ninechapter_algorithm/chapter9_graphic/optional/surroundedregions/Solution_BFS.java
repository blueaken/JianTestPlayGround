package ninechapter_algorithm.chapter9_graphic.optional.surroundedregions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: blueaken
 * Date: 6/17/16 09:25
 */
public class Solution_BFS {
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
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(i, j));
        while (queue.size() > 0) {
            Node current = queue.poll();
            board[current.x][current.y] = to;
            for (int m = 0; m < dx.length; m++) {
                int x = current.x + dx[m];
                int y = current.y + dy[m];
                if (x >= 0 && x < board.length && y >= 0 && y < board[0].length
                        && board[x][y] == from) {
                    queue.offer(new Node(x, y));
                }
            }
        }

        return;
    }

    public static void main(String[] args) {
        Solution_BFS solution = new Solution_BFS();
        char board[][] = {
                { 'X', 'O', 'X', 'X'},
                { 'X', 'O', 'O', 'X'},
                { 'X', 'X', 'O', 'X'},
                { 'X', 'O', 'X', 'X'}
        };
        solution.surroundedRegions(board);
    }

}

class Node {
    int x;
    int y;
    Node (int x, int y) {
        this.x = x;
        this.y = y;
    }
}
