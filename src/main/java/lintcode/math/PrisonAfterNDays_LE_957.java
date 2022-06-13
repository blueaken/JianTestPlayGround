package lintcode.math;

import java.util.*;

public class PrisonAfterNDays_LE_957 {
    /*
        - ref https://leetcode.com/problems/prison-cells-after-n-days/discuss/266854/Java%3A-easy-to-understand
        - there is always a cycle, once the cycle appears, the state map will show again and again following the same rule;
        - if a cycle detected, then fastfarward to the answer directly with hashmap, otherwise just similate the change rule and keep running till N is hit
        - Time is O(K * min(N, 2^K)), K - the number of cells, there are at most 2^K possible states, we run min(N, 2^K) similations steps, without fastwarding in the worst case. Each step takes O(K) time to process.
        - Space is O(K * 2^K) in the worst case.
    */
    public int[] prisonAfterNDays(int[] cells, int n) {
        if (cells == null || cells.length == 0 || n <= 0) {
            return cells;
        }

        Map<Integer, int[]> map = new HashMap<>();
        Set<String> visited = new HashSet<>();
        int cycle = 0;
        boolean hasCycle = false;
        for (int i = 0; i < n; i++) {
            int[] next = nextDay(cells);
            String nextStr = Arrays.toString(next);
            if (!visited.contains(nextStr)) {
                visited.add(nextStr);
                map.put(cycle, next);
                cycle++;
            } else {
                hasCycle = true;
                break;
            }
            cells = next;
        }
        if (hasCycle) {
            n %= cycle;
            //n - 1 is the adjustment for the empty cycle number
            if ((n-1) >= 0) return map.get(n - 1);
        }
        return cells;
    }

    private int[] nextDay(int[] cells) {
        int[] res = new int[cells.length];
        res[0] = 0;
        for (int i = 1; i < cells.length - 1; i++) {
            res[i] = cells[i-1] == cells[i+1] ? 1 : 0;
        }
        res[res.length-1] = 0;
        return res;
    }

    public static void main(String[] args) {
        PrisonAfterNDays_LE_957 solution = new PrisonAfterNDays_LE_957();
        int[] cells = {1,1,0,1,1,0,1,1};
        int n = 6;
        //[0,0,1,0,0,1,0,0]

//        int[] cells = {0,1,0,1,1,0,0,1};
//        int n = 18;
//        //[0,0,0,0,0,1,0,0]

//        int[] cells = {1,0,0,1,0,0,1,0};
//        int n = 1000000000;
//        //[0,0,1,1,1,1,1,0]

        System.out.println(Arrays.toString(solution.prisonAfterNDays(cells, n)));
    }
}
