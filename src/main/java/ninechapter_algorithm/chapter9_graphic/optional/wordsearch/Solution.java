package ninechapter_algorithm.chapter9_graphic.optional.wordsearch;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: blueaken
 * Date: 6/15/16 12:13
 */
public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // write your code here
        if (board == null || board.length == 0
                || board[0] == null || board[0].length == 0
                || word == null) {
            return false;
        }

        char start = word.charAt(0);
        //find start positions
        Set<String> startSet = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == start) {
                    startSet.add(String.valueOf(i) + String.valueOf(j));
                }
            }
        }
        if (startSet.size() == 0) {
            return false;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(start);
        Set<String> visited = new HashSet<>();
        //dfs for each start position
        for (String pos : startSet) {
            visited.add(pos);
            if (rec(board, word, sb, pos, 1, visited)) {
                return true;
            }
            visited.remove(pos);
        }
        sb.deleteCharAt(sb.length() - 1);
        return false;
    }

    private boolean rec(char[][] board, String target, StringBuilder sb,
                        String position,  int index, Set<String> visited) {
        if (sb.length() == target.length()) {
            if (sb.toString().equals(target)) {
                return true;
            }
            return false;
        }

        char next = target.charAt(index);
        int x = position.charAt(0) - '0';
        int y = position.charAt(1) - '0';
        //search horizontal & vertical neighbors
        Set<String> nextPositions = new HashSet<>();
        String nextPosition;
        if (x > 0 && board[x - 1][y] == next) {
            nextPosition = String.valueOf(x - 1) + String.valueOf(y);
            if (!visited.contains(nextPosition)) {
                nextPositions.add(nextPosition);
            }
        }
        if (x < board.length - 1 && board[x + 1][y] == next) {
            nextPosition = String.valueOf(x + 1) + String.valueOf(y);
            if (!visited.contains(nextPosition)) {
                nextPositions.add(nextPosition);
            }
        }
        if (y > 0 && board[x][y - 1] == next) {
            nextPosition = String.valueOf(x) + String.valueOf(y - 1);
            if (!visited.contains(nextPosition)) {
                nextPositions.add(nextPosition);
            }
        }
        if (y < board[0].length - 1 && board[x][y + 1] == next) {
            nextPosition = String.valueOf(x) + String.valueOf(y + 1);
            if (!visited.contains(nextPosition)) {
                nextPositions.add(nextPosition);
            }
        }
        if (nextPositions.size() == 0) {
            return false;
        }

        sb.append(next);
        for (String np : nextPositions) {
            visited.add(np);
            if (rec(board, target, sb, np, index + 1, visited)) {
                return true;
            }
            visited.remove(np);
        }
        sb.deleteCharAt(sb.length() - 1);
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        char board[][] = {
                { 'A', 'B', 'C', 'E'},
                { 'S', 'F', 'C', 'S'},
                { 'A', 'D', 'E', 'E'}
        };
        //expect true -
//        String test = "ABCCED";
//        String test = "SEE";

        //expect false -
        String test = "ABCB";

//        char board[][] = {
//                {'b'},
//                {'a'},
//                {'b'},
//                {'b'},
//                {'a'}
//        };
//        //expect false -
//        String test = "baa";

        System.out.println(solution.exist(board, test));

    }
}
