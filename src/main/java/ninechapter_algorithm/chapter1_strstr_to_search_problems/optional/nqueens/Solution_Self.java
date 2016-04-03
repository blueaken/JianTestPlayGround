package ninechapter_algorithm.chapter1_strstr_to_search_problems.optional.nqueens;

import java.util.ArrayList;

/**
 * Author: blueaken
 * Date: 4/2/16 3:44 PM
 */
public class Solution_Self {
    public static ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }

        rec(result, n, new ArrayList<Integer>());
        return result;
    }

    private static void rec(ArrayList<ArrayList<String>> result, int n, ArrayList<Integer> cols) {
        if (cols.size() == n) {
            //build the result array
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == cols.get(i)) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            result.add(list);
        }

        for (int i = 0; i < n; i++) {
            if (isValid(cols, i)) {
                cols.add(i);
                rec(result, n, cols);
                cols.remove(cols.size()-1);
            }
        }
    }

    private static boolean isValid(ArrayList<Integer> cols, int col) {
        //get current row number
        int row = cols.size();
        for (int i = 0; i < cols.size(); i++) {
            //same column
            if (col == cols.get(i)) {
                return false;
            }
            //diagnal direction
            if (Math.abs(col - cols.get(i)) == row - i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));
    }
}
