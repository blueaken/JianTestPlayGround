package lintcode.backtrack.permutation;

import java.util.ArrayList;
import java.util.List;

public class NQueens_LE_051_P1 {
    /*
        10.20.2022
        ref labaladong post
        type: BackTrack
        - kinda of unease to solve in Java
        - 回溯算法本质上是个多叉树的遍历问题，关键就是在前序遍历和后序遍历的位置做一些操作
        - 动态规划和回溯算法底层都把问题抽象成了树的结构，但这两种算法在思路上是完全不同的
        ======================
        1.8.2023
        - P1 after reading 东哥回溯法帖子
    */

    class Pos {
        int row;
        int col;
        Pos (int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    List<List<String>> res = new ArrayList<>();
    int n;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        // List<Pos> qpositions = new ArrayList<>();
        Pos[] qpositions = new Pos[n];
        backtrack(qpositions, 0);
        return res;
    }

    private void backtrack (Pos[] qpositions, int row) {
        if (row == n) {
            //process qpositions result & add to res
            List<String> solution = new ArrayList<>();
            for (int r = 0; r < n; r++) {
                StringBuilder sb = new StringBuilder();
                for (int c = 0; c < n; c++) {
                    if (qpositions[r].col == c) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                solution.add(sb.toString());
            }
            res.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!isSafe(qpositions, row, col)) {
                continue;
            }
            qpositions[row] = new Pos(row, col);
            backtrack(qpositions, row + 1);
            qpositions[row] = null;
        }
    }

    //note: no need to check down-left and down-right direction, since we iterate from row 0 to bottom
    private boolean isSafe(Pos[] qpositions, int row, int col) {
        //check up direction
        for (int r = 0; r < row; r++) {
            if (qpositions[r].col == col) {
                return false;
            }
        }

        //check up left direction
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (qpositions[r].col == c) {
                return false;
            }
        }

        //check up right direction
        for (int r = row - 1, c = col + 1; r >= 0 && c < n; r--, c++) {
            if (qpositions[r].col == c) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        NQueens_LE_051_P1 solution = new NQueens_LE_051_P1();
        int n = 4;
        System.out.println(solution.solveNQueens(n));
    }
}
