package lintcode.bfs.labuladong;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock_LE_752_P1 {
    /**
     1.13.2023
     ref 东哥 post, 使用BFS框架
     =================
     3.2.2023
     P1
     */
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();
        for (String s : deadends) {
            dead.add(s);
        }

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        visited.add("0000");
        q.offer("0000");
        int step = 0;

        while (q.size() > 0) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                if (dead.contains(cur)){
                    continue;
                }
                if (cur.equals(target)) {
                    return step;
                }

                // visit neighbors
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }

                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }

        return -1;
    }

    private String plusOne(String cur, int pos) {
        char[] arr = cur.toCharArray();
        if (arr[pos] == '9') {
            arr[pos] = '0';
        } else {
            arr[pos]++;
        }
        return new String(arr);
    }

    private String minusOne(String cur, int pos) {
        char[] arr = cur.toCharArray();
        if (arr[pos] == '0') {
            arr[pos] = '9';
        } else {
            arr[pos]--;
        }
        return new String(arr);
    }
}
