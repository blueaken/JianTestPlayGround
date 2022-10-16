package lintcode.dynamicprogramming2.backpack;

import java.util.ArrayList;
import java.util.List;

public class CoinChange_669_SpaceOptimization2 {
    /**
     * @param coins: a list of integer
     * @param amount: a total amount of money amount
     * @return: the fewest number of coins that you need to make up
     */
    // Idea: ref了Tushar优化空间的新video - https://www.youtube.com/watch?v=NJuKJ8sasGk
    //       - 也更新了打印硬币值的算法
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }

        //init
        int size = coins.length;
        int[] res = new int[amount + 1];
        int[] record = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            res[i] = Integer.MAX_VALUE;
            record[i] = -1;
        }
        //for amount 0, there is 0 solution
        res[0] = 0;

        //dp
        for (int i = 1; i <= amount; i++) {
            for (int j = 1; j <= size; j++) {
                if (i >= coins[j-1]) {
                    if ((1 + res[i - coins[j-1]]) < res[i]) {
                        res[i] = 1+ res[i - coins[j-1]];
                        record[i] = j;
                    }
                }
            }
        }

        printCoinCombination(coins, record);
        return res[amount] == Integer.MAX_VALUE ? -1 : res[amount];
    }

    private void printCoinCombination(int[] coins, int[] record) {
        int recPos = record.length - 1;
        List<Integer> used = new ArrayList<>();
        while (recPos > 0) {
            int coinsPos = record[recPos];
            int coinsVal = coins[coinsPos - 1];
            used.add(coinsVal);
            recPos = recPos - coinsVal;
        }
        System.out.println("Coins used: " + used.toString());
    }

    public static void main(String[] args) {
        int amount = 11;
        int[] coins = {1,2,5};

        CoinChange_669_SpaceOptimization2 solution = new CoinChange_669_SpaceOptimization2();
        System.out.println("Fewest nums of coins: " + solution.coinChange(coins, amount));
    }

}
