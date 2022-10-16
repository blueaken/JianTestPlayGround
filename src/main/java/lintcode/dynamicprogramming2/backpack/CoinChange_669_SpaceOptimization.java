package lintcode.dynamicprogramming2.backpack;

public class CoinChange_669_SpaceOptimization {
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
        int[] res = new int[amount+1];
        res[0] = 0;

        //dp
        for (int i = 1; i <= amount; i++) {
            res[i] = Integer.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                if (coins[j] <= i && res[i - coins[j]] != Integer.MAX_VALUE) {
                    res[i] = Math.min(res[i], 1 + res[i - coins[j]]);
                }
            }
        }

        return res[amount] == Integer.MAX_VALUE ? -1 : res[amount];
    }

    public static void main(String[] args) {
        int amount = 11;
        int[] coins = {1,2,5};

        CoinChange_669 solution = new CoinChange_669();
        System.out.println(solution.coinChange(coins, amount));
    }
}
