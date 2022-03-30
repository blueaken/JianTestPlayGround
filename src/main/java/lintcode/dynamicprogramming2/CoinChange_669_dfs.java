package lintcode.dynamicprogramming2;

import java.util.ArrayList;
import java.util.List;

public class CoinChange_669_dfs {
    /**
     * @param coins: a list of integer
     * @param amount: a total amount of money amount
     * @return: the fewest number of coins that you need to make up
     */
    // Idea: dfs solution
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }

        List<Integer> record = new ArrayList<>();
        dfs(record, coins, amount, 0);

        return record.size();
    }

    private void dfs (List<Integer> record, int[] coins, int amount, int pos) {
        if (amount == 0) {
            for (int r : record) {
                System.out.println(r + " ");
            }
            System.out.println("*******");
            return;
        }

        for (int i = pos; i < coins.length; i++) {
            if (amount >= coins[pos]) {
                record.add(coins[i]);
                dfs(record, coins, amount - coins[i], i);
                record.remove(record.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int amount = 11;
        int[] coins = {1,2,5};

        CoinChange_669_dfs solution = new CoinChange_669_dfs();
        solution.coinChange(coins, amount);
//        System.out.println("Fewest nums of coins: " + solution.coinChange(coins, amount));
    }

}
