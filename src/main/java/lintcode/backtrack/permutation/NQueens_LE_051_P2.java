package lintcode.backtrack.permutation;

import java.util.LinkedList;
import java.util.List;

public class NQueens_LE_051_P2 {
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
        ======================
        3.1.2023
        - P2 review东哥帖子
    */

    class Pos{
        int row, col;
        Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    int size;
    List<List<String>> res = new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
        this.size = n;
        Pos[] position = new Pos[n];

        backtrack(position, 0);
        return res;
    }

    private void backtrack(Pos[] position, int n) {
        if (n == size) {
            List<String> solution = new LinkedList<>();
            for (int r = 0; r < size; r++) {
                StringBuilder sb = new StringBuilder();
                for (int c = 0; c < size; c++) {
                    if (position[r].col == c) {
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

        for (int i = 0; i < size; i++) {
            if (isSafe(position, n, i)) {
                position[n] = new Pos(n, i);
                backtrack(position, n+1);
                position[n] = null;
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

        // check up left direction
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (position[r].col == c) {
                return false;
            }
        }

        // check up right direction
        for (int r = row - 1, c = col + 1; r >= 0 && c < size; r--, c++) {
            if (position[r].col == c) {
                return false;
            }
        }

        return true;
    }
}
