package lintcode.dynamicprogramming2.backpack;

import java.util.Arrays;
public class CoinChange_LE_332_TopDown_P1 {
    /*
        5.22.23
        - top down with mem table
    */
    int[] mem;
    public int coinChange(int[] coins, int amount) {
        mem = new int[amount+1];
        Arrays.fill(mem, -666);
        return dp(coins, amount);
    }

    int dp(int[] coins, int amount) {
        // base case;
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        if (mem[amount] != -666) {
            return mem[amount];
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = dp(coins, amount - coin);
            if (subProblem == -1) {
                continue;
            }
            res = Math.min(res, subProblem + 1);
        }
        mem[amount] = (res == Integer.MAX_VALUE ? -1 : res);
        return mem[amount];
    }

    public static void main(String[] args) {
        CoinChange_LE_332_TopDown_P1 solution = new CoinChange_LE_332_TopDown_P1();
        int[] coins = new int[] {1, 2, 5};
        int amount = 1;
        System.out.println(solution.coinChange(coins, amount));
    }
}
