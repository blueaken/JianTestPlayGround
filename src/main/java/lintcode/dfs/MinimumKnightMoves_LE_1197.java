package lintcode.dfs;

import java.util.HashMap;
import java.util.Map;

public class MinimumKnightMoves_LE_1197 {
    /**
     2.10.2023
     - ref solution section - the DFS solution is smart
     - since the board is symmetric, only need to explore 2 directions instead of 8
     - top down DP with memo
     */

    Map<String, Integer> memo = new HashMap<>();

    public int minKnightMoves(int x, int y) {
        return dfs(Math.abs(x), Math.abs(y));
    }

    private int dfs(int x, int y) {
        String key = x + "," + y;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // base case
        if (x + y == 0) {
            return 0;
        }
        if (x + y == 2) {
            return 2;
        }
        int res = Math.min(dfs(Math.abs(x-2), Math.abs(y-1)), dfs(Math.abs(x-1), Math.abs(y-2))) + 1;
        memo.put(key, res);
        return memo.get(key);
    }
}
