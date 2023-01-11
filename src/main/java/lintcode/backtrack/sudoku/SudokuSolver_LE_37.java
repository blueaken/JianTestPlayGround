package lintcode.backtrack.sudoku;

public class SudokuSolver_LE_37 {
    /**
     1.10.2023
     ref 东哥 post
     */
    int N;
    public void solveSudoku(char[][] board) {
        this.N = board.length;
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int i, int j) {
        if (j == N) {
            // 穷举到最后一列的话就换到下一行重新开始。
            return backtrack(board, i+1, 0);
        }

        if (i == N) {
            // 找到一个可行解，触发 base case
            // can log here to see the current board solution
            return true;
        }

        if (board[i][j] != '.') {
            // 如果没有预设数字，不用穷举，到下一列
            return backtrack(board, i, j+1);
        }

        for (char ch = '1'; ch <= '9'; ch++) {
            // 如果当前数字不合法，跳过
            if (!isValid(board, i, j, ch)) {
                continue;
            }

            board[i][j] = ch;
            if (backtrack(board, i, j+1)) {
                //如果找到一个解，结束
                // can log here to see the current board solution
                return true;
            }
            board[i][j] = '.';
        }
        // 穷举完，此路不通，返回
        return false;
    }

    private boolean isValid (char[][] board, int r, int c, char ch) {
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == ch) {
                return false;
            }
            if (board[i][c] == ch) {
                return false;
            }

            // 注意这个Box坐标的算法
            int x = (r/3)*3 + i/3;
            int y = (c/3)*3 + i%3;
            if (board[x][y] == ch) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SudokuSolver_LE_37 solution = new SudokuSolver_LE_37();
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                            {'6','.','.','1','9','5','.','.','.'},
                            {'.','9','8','.','.','.','.','6','.'},
                            {'8','.','.','.','6','.','.','.','3'},
                            {'4','.','.','8','.','3','.','.','1'},
                            {'7','.','.','.','2','.','.','.','6'},
                            {'.','6','.','.','.','.','2','8','.'},
                            {'.','.','.','4','1','9','.','.','5'},
                            {'.','.','.','.','8','.','.','7','9'}};
        solution.solveSudoku(board);
    }
}
