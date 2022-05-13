package lintcode.dfs;

public class WordSearch_LE_79 {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, word, 0, board, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, String word, int pos, char[][] board, boolean[][] visited) {
        if (pos == word.length()) {
            return true;
        }
        if (i != board.length - 1
                && !visited[i+1][j]
                && board[i+1][j] == word.charAt(pos)){
            visited[i+1][j] = true;
            if (dfs(i+1, j, word, pos+1, board, visited)) {
                return true;
            }
            visited[i+1][j] = false;
        }
        if (i != 0
                && !visited[i-1][j]
                && board[i-1][j] == word.charAt(pos)){
            visited[i-1][j] = true;
            if (dfs(i-1, j, word, pos+1, board, visited)) {
                return true;
            }
            visited[i-1][j] = false;
        }
        if (j != board[0].length - 1
                && !visited[i][j+1]
                && board[i][j+1] == word.charAt(pos)) {
            visited[i][j+1] = true;
            if (dfs(i, j+1, word, pos+1, board, visited)) {
                return true;
            }
            visited[i][j+1] = false;
        }
        if (j != 0
                && !visited[i][j-1]
                && board[i][j-1] == word.charAt(pos)){
            visited[i][j-1] = true;
            if (dfs(i, j-1, word, pos+1, board, visited)) {
                return true;
            }
            visited[i][j-1] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        WordSearch_LE_79 solution = new WordSearch_LE_79();
        char[][] board = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        String word = "AAB";
        //true

        System.out.println(solution.exist(board, word));
    }
}
