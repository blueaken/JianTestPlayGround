package lintcode.matrix;

public class GameOfLife_LE_289 {
    /**
     12.08.2022
     ref solution to solve it in place with dummy value indicating the original state
     - if the board is infinite, since it is not an option to load the entire board in the memory; i think one solution is to load only the row above and below along with the current row into memory; since only the neighbour cells matters during the iteration;
     */
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbor = count(board, i, j);
                //rule 1 & 3
                if (board[i][j] == 1 && (liveNeighbor < 2 || liveNeighbor > 3)) {
                    board[i][j] = -1;
                }
                //rule 4
                if (board[i][j] == 0 && liveNeighbor == 3) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] > 0) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }

    private int count(int[][] board, int i, int j) {
        int res = 0;
        int[] neighbour = new int[] {0, 1, -1};
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (!(neighbour[r] == 0 && neighbour[c] == 0)) {
                    int row = i + neighbour[r];
                    int col = j + neighbour[c];

                    if (row >= 0 && row < board.length && col >= 0 && col < board[0].length
                            && Math.abs(board[row][col]) == 1) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
