package lintcode.dynamicprogramming2;

public class BurstBalloons_LE_312 {
    /*
        - similar to LE 1000 MinCost to merge stones
        ref Huifeng Guan - https://www.youtube.com/watch?v=-HtyovJ4s8Q
        - much elegant than previous solution
    */
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n+2];
        System.arraycopy(nums, 0, newNums, 1, nums.length);
        newNums[0] = 1;
        newNums[newNums.length-1] = 1;

        int[][] dp = new int[n+2][n+2];
        for (int len = 1; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k-1] + dp[k+1][j] + newNums[i-1] * newNums[k] * newNums[j+1]);
                }
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        BurstBalloons_LE_312 solution = new BurstBalloons_LE_312();
        int[] nums = {3,1,5,8};//167
        System.out.println(solution.maxCoins(nums));
    }
}
