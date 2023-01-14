package lintcode.bfs.labuladong;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle_LE_773 {
    /**
     1.14.2023
     - ref 东哥 post，本质上还是BFS，碰到这种问最小步数的要敏感地向BFS想一下
     - 本题难点在如何进行BFS的neighbor移动问题，东哥使用将2维数组平摊成1维数组，然后再进行index mapping的方法
     */
    public int slidingPuzzle(int[][] board) {
        // 1维数组neighbor index mapping
        int[][] neighbor = {
                {1, 3},
                {0, 2, 4},
                {1, 5},
                {0, 4},
                {1, 3, 5},
                {2, 4}
        };

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();

        String target = "123450";

        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        Set<String> visited = new HashSet<>();
        visited.add(start);

        int step = 0;
        while (queue.size() > 0) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String cur = queue.poll();
                if (cur.equals(target)) {
                    return step;
                }

                // find empty space position
                int idx = 0;
                for (int j = 0; j < cur.length(); j++) {
                    if (cur.charAt(j) == '0') {
                        idx = j;
                        break;
                    }
                }

                for (int neigh : neighbor[idx]) {
                    String str = swap(cur, idx, neigh);
                    if (!visited.contains(str)) {
                        queue.offer(str);
                        visited.add(str);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String swap (String str, int i, int j) {
        char[] ch = str.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return new String(ch);
    }
}
