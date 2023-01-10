package lintcode.backtrack.sudoku;

public class ValidSudoku_LE_36 {
    /**
     1.10.2023
     - ref 东哥 le 37 post中代码片段 && official solution 2
     - Each position (pos) in the array represents the status of the number pos + 1. Therefore, we can determine if we have already seen some number in constant time.
     */
    public boolean isValidSudoku(char[][] board) {
        int N = 9;
        int[][] row = new int[N][N];
        int[][] col = new int[N][N];
        int[][] box = new int[N][N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (board[r][c] == '.') {
                    continue;
                }
                int pos = board[r][c] - '1';

                if (row[r][pos] == 1) {
                    return false;
                }
                row[r][pos] = 1;

                if (col[c][pos] == 1) {
                    return false;
                }
                col[c][pos] = 1;

                int curBox = (r/3)*3 + c/3;
                if (box[curBox][pos] == 1) {
                    return false;
                }
                box[curBox][pos] = 1;
            }
        }
        return true;
    }
}
