package lintcode.dynamicprogramming.matrix;

public class DungeonGame_LE_174 {
    /*
        10.21.2022
        ref labuladong post
        Matrix DP - & must start from bottom-right to up-left, since the destination (bottom-right cell) can be a demon with negative health point
        - solve it with bottom up DP with DP table
        - dp array size be m+1, n+1, for the ease of coding
    */
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m+1][n+1];

        //init
        dp[m-1][n-1] = dungeon[m-1][n-1] > 0 ? 1 : -1 * dungeon[m-1][n-1] + 1;
        for (int i = 0; i < m; i++) {
            dp[i][n] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < n; i++) {
            dp[m][i] = Integer.MAX_VALUE;
        }

        //dp
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (i == m-1 && j == n-1) { //has been initiated
                    continue;
                }
                dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j];
                dp[i][j] = Math.max(dp[i][j], 1); //avoid negative health point in case pos[i][j] has a big power-up
            }
        }
        return dp[0][0];
    }
}
