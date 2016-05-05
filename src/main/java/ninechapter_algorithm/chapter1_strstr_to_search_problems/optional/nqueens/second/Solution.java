package ninechapter_algorithm.chapter1_strstr_to_search_problems.optional.nqueens.second;

import java.util.ArrayList;

/**
 * Author: blueaken
 * Date: 5/5/16 09:43
 */
public class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        rec(result, n, new ArrayList<Integer>());
        return result;
    }

    private void rec(ArrayList<ArrayList<String>> result, int n, ArrayList<Integer> list) {
        if (list.size() == n) {
            //draw grid
            ArrayList<String> row = new ArrayList<>();
            for (Integer i : list) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == i) {
                        sb.append("Q");
                    }else {
                        sb.append(".");
                    }
                }
                row.add(sb.toString());
            }
            result.add(row);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(list, i)) {
                list.add(i);
                rec(result, n, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isValid(ArrayList<Integer> list, int candidate) {
        if (list.size() == 0) {
            return true;
        }
        //same column
        if (list.contains(candidate)) {
            return false;
        }

        int candidateRow = list.size();
        for (int row = 0; row < list.size(); row++) {
            //on cross directions
            if (Math.abs(list.get(row) - candidate) == Math.abs(row - candidateRow)) {
                return false;
            }
        }
        return true;
    }
}
