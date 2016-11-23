package ninechapter_algorithm.chapter9_graphic.optional.wordsearch;

/**
 * Author: blueaken
 * Date: 6/15/16 15:39
 */
public class Solution_NineChapter {
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

        //dfs for each start positions
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (rec(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean rec(char[][] board, String target, int i, int j,  int index) {
        if (index == target.length()) {
            return true;
        }

        char cur = target.charAt(index);
        if (i < 0 || i == board.length || j < 0 || j == board[0].length
                || board[i][j] != cur) {
            return false;
        }

        //reset cur position to avoid traverse back
        board[i][j] = '#';
        //search horizontal & vertical neighbors
        boolean ret = rec(board, target, i - 1, j, index + 1)
                || rec(board, target, i + 1, j, index + 1)
                || rec(board, target, i, j + 1, index + 1)
                || rec(board, target, i, j - 1, index + 1);
        //reset cur position back for other start points
        board[i][j] = cur;

        return ret;
    }

    public static void main(String[] args) {
        Solution_NineChapter solution_nineChapter = new Solution_NineChapter();
//        char board[][] = {
//                { 'A', 'B', 'C', 'E'},
//                { 'S', 'F', 'C', 'S'},
//                { 'A', 'D', 'E', 'E'}
//        };
        //expect true -
//        String test = "ABCCED";
//        String test = "SEE";
        //expect false -
//        String test = "ABCB";

        char board[][] = {
                { 'A', 'B', 'C', 'E'},
                { 'S', 'F', 'E', 'S'},
                { 'A', 'D', 'E', 'E'}
        };
        //expect true -
        String test = "ABCESEEEFS";



//        char board[][] = {
//                {'b'},
//                {'a'},
//                {'b'},
//                {'b'},
//                {'a'}
//        };
//        //expect false -
//        String test = "baa";

        System.out.println(solution_nineChapter.exist(board, test));
    }
}
