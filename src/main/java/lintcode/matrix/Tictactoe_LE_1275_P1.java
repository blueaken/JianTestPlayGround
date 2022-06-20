package lintcode.matrix;

public class Tictactoe_LE_1275_P1 {
    /*
        Ref to solution - https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/solution/,
        and try to solve it by first loading all moves and then check the result, instead of after each move,
        which should be more time efficient than the original solution
    */
    public String tictactoe(int[][] moves) {
        int len = moves.length;
        int n = 3; //can fit to general case in future
        int player = 1;
        int[] rows = new int[n];
        int[] cols = new int[n];
        int diag = 0;
        int anti_diag = 0;

        //loading all move info
        for (int i = 0; i < len; i++) {
            int row = moves[i][0], col = moves[i][1];
            rows[row] += player;
            cols[col] += player;

            if (row == col) {
                diag += player;
            }
            if (row + col == n - 1) {
                anti_diag += player;
            }

            player *= -1; //switch player
        }

        //evaluate the results
        for (int i = 0; i < n; i++) {
            if (rows[i] == 3 || cols[i] == 3) {
                return "A";
            }
            if (rows[i] == -3 || cols[i] == -3) {
                return "B";
            }
        }
        if (diag == 3 || anti_diag == 3) {
            return "A";
        }
        if (diag == -3 || anti_diag == -3) {
            return "B";
        }

        return len < 9 ? "Pending" : "Draw";
    }

    public static void main(String[] args) {
        Tictactoe_LE_1275_P1 solution = new Tictactoe_LE_1275_P1();
//        int[][] moves = {{0,0},{2,0},{1,1},{2,1},{2,2}};//A
        int[][] moves = {{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}};//B
//        int[][] moves = {{0,2},{1,0},{2,2},{1,2},{2,0},{0,0},{0,1},{2,1},{1,1}};//A
        System.out.println(solution.tictactoe(moves));
    }
}
