package lintcode.matrix;

public class DesignTicTacToe_LE_348 {
    /*
        - follow the soluton of 1275, should be easy.
        - but it is a challenge to get better than O(N^2) per move()
    */

    int n;
    int[] rows;
    int[] cols;
    int diagnal;
    int anti_diagnal;

    public DesignTicTacToe_LE_348(int n) {
        this.n = n;
        this.rows = new int[n];
        this.cols = new int[n];
        this.diagnal = 0;
        this.anti_diagnal = 0;
    }

    /*
      Time actually is O(1), since each move, we mark a particlar row, column, diagnal and anti-diagnal in constant timel Space is O(N)
    */
    public int move(int row, int col, int player) {
        int ind = 0;
        if (player == 1) {
            ind = 1;
        } else {
            ind = -1;
        }

        //update move info
        rows[row] += ind;
        cols[col] += ind;
        if (row == col) {
            diagnal += ind;
        }
        if (row + col == n - 1) {
            anti_diagnal += ind;
        }

        //analyze result and return
        for (int i = 0; i < n; i++) {
            if (rows[i] == n || cols[i] == n) {
                return 1; // player 1 wins
            }
            if (rows[i] == -n || cols[i] == -n) {
                return 2; // player 2 wins
            }
        }
        if (diagnal == n || anti_diagnal == n) {
            return 1;
        }
        if (diagnal == -n || anti_diagnal == -n) {
            return 2;
        }

        //else game still pending, return 0
        return 0;
    }
}
