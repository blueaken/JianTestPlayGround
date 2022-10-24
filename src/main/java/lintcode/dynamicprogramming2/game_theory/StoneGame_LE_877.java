package lintcode.dynamicprogramming2.game_theory;

public class StoneGame_LE_877 {
    /*
        10.24.2022
        ref labaladong post - solve it with bottom up DP
    */
    public boolean stoneGame(int[] piles) {
        // return true;

        int n = piles.length;
        int[][][] dp = new int[n][n][2];

        //init, len = 1 case
        for (int i = 0; i < n; i++) {
            dp[i][i][0] = piles[i];
            dp[i][i][1] = 0;
        }

        //dp
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                int left = piles[i] + dp[i+1][j][1];
                int right = piles[j] + dp[i][j-1][1];

                if (left > right) {
                    dp[i][j][0] = left;
                    dp[i][j][1] = dp[i+1][j][0];
                } else {
                    dp[i][j][0] = right;
                    dp[i][j][1] = dp[i][j-1][0];
                }
            }
        }

        return dp[0][n-1][0] > dp[0][n-1][1];
    }
}
