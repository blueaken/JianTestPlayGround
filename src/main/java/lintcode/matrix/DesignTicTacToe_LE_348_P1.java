package lintcode.matrix;

public class DesignTicTacToe_LE_348_P1 {
    /*
        - follow the solution of 1275, should be easy.
        - but it is a challenge to get better than O(N^2) per move()
    */

    //init
    int n;
    int[] rows;
    int[] cols;
    int diag;
    int anti_diag;

    public DesignTicTacToe_LE_348_P1(int n) {
        this.n = n;
        this.rows = new int[n];
        this.cols = new int[n];
        this.diag = 0;
        this.anti_diag = 0;
    }

    /*
      Time actually is O(1), since each move, we mark a particular row, column, diagonal and anti-diagonal in constant time Space is O(N)
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
            diag += ind;
        }
        if (row + col == n - 1) {
            anti_diag += ind;
        }

        //evaluate the results
        for (int i = 0; i < n; i++) {
            if (rows[i] == n || cols[i] == n) {
                return 1; //player 1 wins
            }
            if (rows[i] == -n || cols[i] == -n) {
                return 2; //player 2 wins
            }
        }
        if (diag == n || anti_diag == n) {
            return 1;
        }
        if (diag == -n || anti_diag == -n) {
            return 2;
        }

        return 0;
    }
}
/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
