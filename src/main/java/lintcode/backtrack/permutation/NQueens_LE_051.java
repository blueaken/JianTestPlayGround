package lintcode.backtrack.permutation;

import java.util.ArrayList;
import java.util.List;

public class NQueens_LE_051 {
    /*
        10.20.2022
        ref labaladong post
        type: BackTrack
        - kinda of unease to solve in Java
        - 回溯算法本质上是个多叉树的遍历问题，关键就是在前序遍历和后序遍历的位置做一些操作
        - 动态规划和回溯算法底层都把问题抽象成了树的结构，但这两种算法在思路上是完全不同的
    */
    class QPosition {
        int row, col;
        QPosition (int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        QPosition[] qpositions = new QPosition[n];
        backtrack(qpositions, 0);

        return res;
    }

    private void backtrack(QPosition[] qpositions, int row) {
        int n = qpositions.length;

        if (row == n) {
            //make result list
            List<String> list = new ArrayList<>();
            for (int r = 0; r < n; r++) {
                StringBuilder sb = new StringBuilder();
                for (int c = 0; c < n; c++) {
                    if (qpositions[r].col == c) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                list.add(sb.toString());
            }
            res.add(list);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, qpositions)) {
                qpositions[row] = new QPosition(row, col);
                backtrack(qpositions, row+1);
                qpositions[row] = null;
            }
        }
    }

    //note: no need to check down-left and down-right direction, since we iterate from row 0
    private boolean isSafe(int row, int col, QPosition[] qpositions) {
        int n = qpositions.length;
        //check if col above is safe
        for (int i = 0; i < row; i++) {
            if (qpositions[i].col == col) {
                return false;
            }
        }

        //check if up-left is safe
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (qpositions[i].col == j) {
                return false;
            }
        }

        //check if up-right is safe
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (qpositions[i].col == j) {
                return false;
            }
        }

        return true;
    }
}
