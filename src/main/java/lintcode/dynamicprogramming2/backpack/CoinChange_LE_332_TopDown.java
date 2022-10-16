package lintcode.dynamicprogramming2.backpack;

import java.util.Arrays;

public class CoinChange_LE_332_TopDown {
    /*
        10.16.2022
        read labaladong post on dynamic programming
        - 动态规划问题的一般形式就是求最值。动态规划其实是运筹学的一种最优化方法，只不过在计算机问题上应用比较多.
        - 动态规划的核心问题是穷举。因为要求最值，肯定要把所有可行的答案穷举出来，然后在其中找最值呗。
        - 虽然动态规划的核心思想就是穷举求最值，但是问题可以千变万化，穷举所有可行解其实并不是一件容易的事，需要你熟练掌握递归思维，只有列出正确的「状态转移方程」，才能正确地穷举。
        - 而且，你需要判断算法问题是否具备「最优子结构」，是否能够通过子问题的最值得到原问题的最值。另外，动态规划问题存在「重叠子问题」，如果暴力穷举的话效率会很低，所以需要你使用「备忘录」或者「DP table」来优化穷举过程，避免不必要的计算。
        - 以上提到的重叠子问题、最优子结构、状态转移方程就是动态规划三要素。具体什么意思等会会举例详解，但是在实际的算法问题中，写出状态转移方程是最困难的，这也就是为什么很多朋友觉得动态规划问题困难的原因，我来提供我总结的一个思维框架，辅助你思考状态转移方程：明确 base case -> 明确「状态」-> 明确「选择」 -> 定义 dp 数组/函数的含义。按照这个套路得出2个基本框架：
        - 1. # 自顶向下递归的动态规划 （Top Down）
            def dp(状态1, 状态2, ...):
            for 选择 in 所有可能的选择:
                # 此时的状态已经因为做了选择而改变
                result = 求最值(result, dp(状态1, 状态2, ...))
            return result

         - 2. # 自底向上迭代的动态规划 (Bottom Up)
            # 初始化 base case
            dp[0][0][...] = base case
            # 进行状态转移
            for 状态1 in 状态1的所有取值：
                for 状态2 in 状态2的所有取值：
                    for ...
                        dp[状态1][状态2][...] = 求最值(选择1，选择2...)
     ======================================================
     本题：状态转移方程：
     dp(int[] coins, int amount) - 要凑出金额amount, 至少需要dp(coins, amount)个硬币
        for (coin : coins) {
            res = min(res, dp(coins, amount - coin) + 1);
        }
     1. 使用上述mem 备忘录，Top Down solution
     2. 使用上述DP Table, Button Up solution

    */

    int[] mem;
    public int coinChange(int[] coins, int amount) {
        mem = new int[amount + 1];
        Arrays.fill(mem, -666); // init a special value that impossible to reach
        return dp(coins, amount);
    }

    private int dp(int[] coins, int amount) {
        //base case
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
            int sub = dp(coins, amount - coin);
            //skip if no solution in sub problem
            if (sub == -1) {
                continue;
            }
            res = Math.min(res, sub + 1);
        }

        mem[amount] = res == Integer.MAX_VALUE ? -1 : res;
        return mem[amount];
    }
}
