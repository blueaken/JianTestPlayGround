package ninechapter_algorithm.chapter1_strstr_to_search_problems.optional.nqueens;

import java.util.ArrayList;

/**
 * Author: blueaken
 * Date: 4/2/16 3:02 PM
 */
public class Solution {
    private static String[] drawChessboard(ArrayList<Integer> cols) {
        String[] chessboard = new String[cols.size()];
        for (int i = 0; i < cols.size(); i++) {
            chessboard[i] = "";
            for (int j = 0; j < cols.size(); j++) {
                if (j == cols.get(i)) {
                    chessboard[i] += "Q";
                } else {
                    chessboard[i] += ".";
                }
            }
        }

        return chessboard;
    }

    private static boolean isValid(ArrayList<Integer> cols, int col) {
        int row = cols.size();
        for (int i = 0; i < row; i++) {
            // same column
            if (cols.get(i)== col)  {
                return false;
            }
//            // left-top to right-bottom
//            if (i - cols.get(i) == row - col) {
//                return false;
//            }
//            // right-top to left-bottom
//            if (i + cols.get(i) == row + col) {
//                return false;
//            }
            //on the corner
            if (Math.abs(col - cols.get(i)) == row - i) {
                return false;
            }
        }
        return true;
    }

    private static void search(int n, ArrayList<Integer> cols, ArrayList<String[]> result) {
        if (cols.size() == n) {
            result.add(drawChessboard(cols));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!isValid(cols, col)) {
                continue;
            }
            cols.add(col);
            search(n, cols, result);
            cols.remove(cols.size() - 1);
        }
    }

    public static ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        search(n, new ArrayList<Integer>(), result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
