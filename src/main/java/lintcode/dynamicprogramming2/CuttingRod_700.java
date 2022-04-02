package lintcode.dynamicprogramming2;

public class CuttingRod_700 {
    /**
     * @param prices: the prices
     * @param n: the length of rod
     * @return: the max value
     */
    public int cutting(int[] prices, int n) {
        // Write your code here
        if (prices == null || prices.length == 0) {
            return 0;
        }

        //init
        int size = prices.length;
        int res[][] = new int [size+1][n+1];

        //dp
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= i) {
                    res[i][j] = Math.max(res[i-1][j], prices[i-1] + res[i][j-i]);
                } else {
                    res[i][j] = res[i-1][j];
                }
            }
        }
        return res[size][n];
    }

    public static void main(String[] args) {
        int[] prices = {2,5,7,8};
        int n = 5;

        CuttingRod_700 solution = new CuttingRod_700();
        System.out.println(solution.cutting(prices, n));
    }
}
