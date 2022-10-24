package lintcode.dynamicprogramming2;

import java.util.Arrays;

public class DropEgg_LE_887_TopDown_PlusBinarySearch_ForRef {
    /*
        10.24.2022
        ref labaladong post
        - if without egg limit, the best way to solve is binary search. With egg limit, it become a DP problem.
        - top down DP with mem cache
    */
    int[][]mem;
    public int superEggDrop(int k, int n) {
        mem = new int[k+1][n+1];
        for (int[] row : mem) {
            Arrays.fill(row, -666);
        }

        return dp(k, n);
    }

    private int dp(int k, int n) {
        //base case
        if (k == 1) {
            //with only 1 egg, must do a linear search each floor
            return n;
        }
        if (n == 0) {
            return 0;
        }

        if (mem[k][n] != -666) {
            return mem[k][n];
        }

        //dp
        int res = Integer.MAX_VALUE;
        int lo = 1, hi = n;
        //use labaladong's BS template just for ref ...
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int broken_val = dp(k-1, mid-1);
            int unBroken_val = dp(k, n - mid);
            if (broken_val > unBroken_val) {
                hi = mid - 1;
                res = Math.min(res, broken_val + 1);
            } else {
                lo = mid + 1;
                res = Math.min(res, unBroken_val + 1);
            }
        }

        mem[k][n] = res;
        return mem[k][n];
    }
}
