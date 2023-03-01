package lintcode.backtrack.permutation;

public class NQueens2_LE_052 {
    class Pos {
        int row, col;
        Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    int size = 0;
    int res = 0;
    public int totalNQueens(int n) {
        this.size = n;
        Pos[] position = new Pos[n];
        backtrack(position, 0);

        return res;
    }

    private void backtrack(Pos[] position, int row) {
        if (row == this.size) {
            res++;
            return;
        }

        for (int col = 0; col < size; col++) {
            if (isSafe(position, row, col)) {
                position[row] = new Pos(row, col);
                backtrack(position, row+1);
                position[row] = null;
            }
        }
    }

    private boolean isSafe(Pos[] position, int row, int col) {
        // check up direction
        for (int r = 0; r < row; r++) {
            if (position[r].col == col) {
                return false;
            }
        }

        // check up left
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (position[r].col == c) {
                return false;
            }
        }

        // check up right
        for (int r = row - 1, c = col + 1; r >= 0 && c < size; r--, c++) {
            if (position[r].col == c) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        NQueens2_LE_052 solution = new NQueens2_LE_052();
        int n = 4;
        System.out.println(solution.totalNQueens(n));
    }
}
