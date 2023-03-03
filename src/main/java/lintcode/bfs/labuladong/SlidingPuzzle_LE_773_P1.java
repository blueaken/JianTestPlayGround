package lintcode.bfs.labuladong;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle_LE_773_P1 {
    /**
     1.14.2023
     - ref 东哥 post，本质上还是BFS，碰到这种问最小步数的要敏感地向BFS想一下
     - 本题难点在如何进行BFS的neighbor移动问题，东哥使用将2维数组平摊成1维数组，然后再进行index mapping的方法
     =======================
     3.3.2023
     P1
     */
    public int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();
        String target = "123450";

        int[][] neighbor = {
                {1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}
        };

        Set<String> visited = new HashSet<>();
        visited.add(start);
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        int step = 0;

        while (q.size() > 0) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                if (cur.equals(target)) {
                    return step;
                }

                // find '0' position
                int idx = 0;
                for (int j = 0; j < cur.length(); j++) {
                    char c = cur.charAt(j);
                    if (c == '0') {
                        idx = j;
                    }
                }

                // visit neighbor positions
                for (int neigh : neighbor[idx]) {
                    String neighPos = swap(cur, idx, neigh);
                    if (!visited.contains(neighPos)) {
                        q.offer(neighPos);
                        visited.add(neighPos);
                    }
                }

            }
            step++;
        }
        return -1;
    }

    private String swap(String str, int i, int j) {
        char[] arr = str.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return new String(arr);
    }
}
