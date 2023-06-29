package lintcode.dynamicprogramming2;

/*
        - similar to LE 1000 MinCost to merge stones
        ref Huifeng Guan - https://www.youtube.com/watch?v=-HtyovJ4s8Q
        - much elegant than previous solution
        ======================
        P1 10.24.2022
        ref labuladong post
        - solve with bottom up DP, the definition is different from Huifeng Guan's, but similar.
        - still use Huifeng Guan's DP formula definition
        ==================
        6.29.23
        - ref 东哥 post
    */
public class BurstBalloons_LE_312_P2 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] points = new int[n+2];
        points[0] = points[n+1] = 1;
        for (int i = 0; i < n; i++) {
            points[i+1] = nums[i];
        }

        // dp[i][j] 是从i到j之间取得的最大成绩，i，j是开区间
        int[][] dp = new int[n+2][n+2];
        for (int len = 1; len <= n+1; len++) {
            for (int i = 0; i <= n + 1 - len; i++) { // “n + 1 - len” matches the length of points array
                int j = i + len;
                // i, j是开区间，k的取值应是它们之间，取不到i, j本身,这里穷举最后一个气球是i到j之间每一个位置的情况
                for (int k = i+1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + points[i]*points[k]*points[j] + dp[k][j]);
                }
            }
        }
        return dp[0][n+1];
    }

    public static void main(String[] args) {
        BurstBalloons_LE_312_P2 solution = new BurstBalloons_LE_312_P2();
//        int[] nums = {3,1,5,8};//167
        int[] nums = {1,5};//10
        System.out.println(solution.maxCoins(nums));
    }
}
