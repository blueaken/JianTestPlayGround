package ninechapter_algorithm.chapter1_strstr_to_search_problems.optional.nqueens.third;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 6/12/16 09:26
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

        helper(result, n, new ArrayList<Integer>());
        return result;
    }

    void helper(ArrayList<ArrayList<String>> result, int n, List<Integer> list) {
        if (list.size() == n) {
            printList(result, list);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (list.contains(i)) {
                continue;
            }
            if (isValid(list, i)){
                list.add(i);
                helper(result, n, list);
                list.remove(list.size() - 1);
            }
        }
    }

    void printList(ArrayList<ArrayList<String>> result, List<Integer> list) {
        ArrayList<String> temp = new ArrayList<>();
        int n = list.size();
        for (int i = 0; i < n; i++) {
            int cur = list.get(i);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == cur) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            temp.add(sb.toString());
        }
        result.add(temp);
    }

    boolean isValid(List<Integer> list, int colCandidate) {
        int rowNum = list.size();
        if (rowNum == 0) {
            return true;
        }
        for (int row = 0; row < rowNum; row++) {
            //same column
            if (colCandidate == list.get(row)) {
                return false;
            }
            //on diagonal line
            if ((rowNum - row) == Math.abs(colCandidate - list.get(row))) {
                return false;
            }
        }
        return true;
    }
}
