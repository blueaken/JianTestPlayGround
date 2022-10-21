package lintcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreedomTrail_LE_514 {
    /*
        ref labuladong post
        - try solve with Top Down DP optimized with mem cache
    */
    int[][] mem;
    Map<Character, List<Integer>> charToIndex = new HashMap<>();
    public int findRotateSteps(String ring, String key) {
        int m = ring.length();
        int n = key.length();
        mem = new int[m][n];

        for (int i = 0; i < m; i++) {
            char cur = ring.charAt(i);
            if (!charToIndex.containsKey(cur)) {
                charToIndex.put(cur, new ArrayList<>());
            }
            charToIndex.get(cur).add(i);
        }

        return dp(ring, 0, key, 0);
    }

    //dp: the min steps to operate when 12 o'clock points to ring[i], input String key[j...]
    private int dp(String ring, int i, String key, int j) {
        //base case
        if (j == key.length()) {
            return 0;
        }

        //avoid duplicate calc
        if (mem[i][j] != 0) {
            return mem[i][j];
        }


        int size = ring.length();
        int res = Integer.MAX_VALUE;
        //there can be multiple char key[j] on the ring, iterate each of it
        for (int k : charToIndex.get(key.charAt(j))) {
            int delta = Math.abs(k - i);
            delta = Math.min(delta, size - delta); //find the min steps between clockwise and anticlockwise
            int sub = dp(ring, k, key, j+1);
            res = Math.min(res, 1 + sub + delta); //1 - for push button step
        }
        mem[i][j] = res;
        return mem[i][j];
    }
}
