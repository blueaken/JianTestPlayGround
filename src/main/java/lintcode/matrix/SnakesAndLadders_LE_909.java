package lintcode.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders_LE_909 {
    /*
        - get value is strange for the Boustrophedon style, visit it later, like the bfs part
        - ref https://leetcode.com/problems/snakes-and-ladders/discuss/173682/Java-concise-solution-easy-to-understand
    */
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        int move = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer cur = queue.poll();
                if (visited[cur]) {
                    continue;
                }
                visited[cur] = true;
                if (cur == n * n) {
                    return move;
                }
                for (int j = 1; j <= 6 && cur + j <= n * n; j++) {
                    int next = cur + j;
                    int value = getBoardValue(board, next);
                    if (value > 0) {
                        next = value;
                    }
                    if (!visited[next]) {
                        queue.offer(next);
                    }
                }
            }
            move++;
        }
        return -1;
    }

    private int getBoardValue(int[][] board, int num) {
        int n = board.length;
        int row = (num - 1) / n;
        int x = n - 1 - row;
        int y = row % 2 == 0 ? num - 1 - row * n : (row + 1) * n - num;
        return board[x][y];
    }
}
