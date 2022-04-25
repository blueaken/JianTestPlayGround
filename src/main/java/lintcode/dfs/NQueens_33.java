package lintcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class NQueens_33 {

    class Position {
        int row, col;
        Position (int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    /**
     * @param n: The number of queens
     * @return: All distinct solutions
     *          we will sort your return value in output
     */
    // Ref - https://www.youtube.com/watch?v=xouin83ebxE & previous notes, make necessary modifications
    //     - use this as template for permutation questions?
    public List<List<String>> solveNQueens(int n) {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        Position[] positions = new Position[n];
        rec(n, 0, positions, res);

        return res;
    }

    private void rec (int n, int row, Position[] positions, List<List<String>> res) {
        if (n == row) {
            //Make Result String
            ArrayList<String> list = new ArrayList<>();
            for (int r = 0; r < n; r++) {
                StringBuilder sb = new StringBuilder();
                for (int c = 0; c < n; c++) {
                    if (positions[r].col == c) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            res.add(list);
            return;
        }
        for (int col = 0; col < n; col++) {
            boolean foundSafe = true;

            //check if this row and col is under attack from any previous queen
            foundSafe = isSafe(row, col, positions);

            if (foundSafe) {
                positions[row] = new Position (row, col);
                rec (n, row + 1, positions, res);
            }
        }
    }

    private boolean isSafe (int row, int col, Position[] positions) {
        for (int queen = 0; queen < row; queen++) {
            if (positions[queen].row == row || positions[queen].col == col
                    || positions[queen].row - positions[queen].col == row - col
                    || positions[queen].row + positions[queen].col == row + col) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueens_33 solution = new NQueens_33();
        System.out.println(solution.solveNQueens(4));
    }
}
