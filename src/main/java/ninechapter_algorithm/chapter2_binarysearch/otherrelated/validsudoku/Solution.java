package ninechapter_algorithm.chapter2_binarysearch.otherrelated.validsudoku;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: blueaken
 * Date: 6/21/16 10:19
 */
public class Solution {
    /**
     * @param board: the board
     @return: wether the Sudoku is valid
     */
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9
                || board[0] == null || board[0].length != 9) {
            return false;
        }

        //check rows
        for (int i = 0; i < 9; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (!validate(board[i][j], set)) {
                    return false;
                }
            }
        }

        //check cols
        for (int i = 0; i < 9; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (!validate(board[j][i], set)) {
                    return false;
                }
            }
        }

        //check sub matrix
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Set<Integer> set = new HashSet<>();
                for (int k = 0; k < 9; k++) {
                    if (!validate(board[i + k / 3][j + k % 3], set)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean validate(char candidate, Set<Integer> set) {
        if (candidate == '.') {
            return true;
        } else {
            int cur = candidate - '0';
            if (cur >= 0 && cur <= 9 && !set.contains(cur)) {
                set.add(cur);
                return true;
            }
            return false;
        }
    }
}
