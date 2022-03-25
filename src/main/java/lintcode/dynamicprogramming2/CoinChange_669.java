package lintcode.dynamicprogramming2;

public class CoinChange_669 {
    /**
     * @param coins: a list of integer
     * @param amount: a total amount of money amount
     * @return: the fewest number of coins that you need to make up
     */
    // Idea: ref了Tushar's video, 本质上是个背包问题，但发现他提供的算法中没有初始化，找了leetcode上帖子对初始化进行了优化，并且优化了
    // 时间复杂度和空间复杂度得到一个新的算法。另外发现codeantenna.com上一篇帖子也不错。
    // Ref - https://www.youtube.com/watch?v=Y0ZqKpToTic&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr
    //     - https://leetcode.com/problems/coin-change/discuss/455358/Java-solution-Solved-as-a-backpack-problem-beat-97
    //     - https://codeantenna.com/a/vT1F6MGaI6

    public int coinChange(int[] coins, int amount) {
        // write your code here
        if (amount == 0) {
            return 0;
        }
        if (coins == null || coins.length == 0) {
            return -1;
        }

        //init
        int len = coins.length;
        int[][] res = new int[len+1][amount+1];
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j == 0) {
                    continue;
                }
                res[i][j] = amount + 1;
            }
        }

        //dp
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i-1] > j) {
                    res[i][j] = res[i-1][j];
                } else {
                    res[i][j] = Math.min(res[i-1][j], 1 + res[i][j-coins[i-1]]);
                }
            }
        }

        return res[len][amount] > amount ? -1 : res[len][amount];
    }

    public static void main(String[] args) {
        int amount = 11;
        int[] coins = {1,2,5};

        CoinChange_669 solution = new CoinChange_669();
        System.out.println(solution.coinChange(coins, amount));
    }
}
