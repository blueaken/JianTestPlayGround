package lintcode.dynamicprogramming2;

import java.util.Arrays;

public class DropEgg_LE_887_TopDown {
    /*
        10.24.2022
        ref labaladong post
        - if without egg limit, the best way to solve is binary search. With egg limit, it become a DP problem.
        - top down DP with mem cache
        - 动态规划算法的时间复杂度就是子问题个数 × 函数本身的复杂度 = O(KN * N) = O(KN^2)
        - 能用二分进一步优化
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
        for (int i = 1; i <= n; i++) {
            //current move is the max moves of the case egg broken and the case egg not broken PLUS one (for the current move)
            int cur = Math.max(dp(k-1, i-1), dp(k, n-i)) + 1;
            res = Math.min(res, cur);
        }
        mem[k][n] = res;
        return mem[k][n];
    }
}
