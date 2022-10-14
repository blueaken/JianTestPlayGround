package lintcode.dynamicprogramming;

public class BestTimeToBuyAndSellStock4_393 {
    /**
     * @param k: An integer
     * @param prices: An integer array
     * @return: Maximum profit
     */
	/*
		Idea: ref 1st part of https://www.youtube.com/watch?v=oDhu5uGq_ic, Backpack DP without memory optimization
	*/
    public int maxProfit(int k, int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0 || k == 0) {
            return 0;
        }

        int [][] res = new int[k + 1][prices.length];
        //res[0][j] = 0, since no transaction make 0 profit; res[i][0] = 0, since buy & sell in one day does not make profit

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < prices.length; j++) {
                int profitWithoutTran = res[i][j - 1];
                int maxProfitWithTran = 0;
                for (int m = 0; m < j; m++) {
                    maxProfitWithTran = Math.max(maxProfitWithTran, prices[j] - prices[m] + res[i - 1][m]);
                }
                res[i][j] = Math.max(profitWithoutTran, maxProfitWithTran);
            }
        }
        return res[k][prices.length - 1];
    }

    public static void main(String[] args) {
        int[] prices = {2,5,7,1,4,3,1,3};
        int k = 2;
        //expect 8

        BestTimeToBuyAndSellStock4_393 solution = new BestTimeToBuyAndSellStock4_393();
        System.out.println(solution.maxProfit(k, prices));
    }
}
