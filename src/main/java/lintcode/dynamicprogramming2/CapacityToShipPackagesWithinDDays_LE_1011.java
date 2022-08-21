package lintcode.dynamicprogramming2;

public class CapacityToShipPackagesWithinDDays_LE_1011 {
    /*
        - almost same as 410
        - gut feeling is dp
        - ref 花花 https://www.youtube.com/watch?v=_k-Jb4b7b_0 & Huifeng Guan https://www.youtube.com/watch?v=-F2ysRiSTvk
        - dp[i][j]: i - number of groups, j - number of elements involved, from start of array
        - dp[1][j] = sum(0 ... j), when only 1 group, the ans is just sum every element invloved
        - dp[i][j] = min{max(dp[i-1][k], sum(k+1 ... j))}, 0 <= k < j, basically try every cutting point and find the minimum largest sum
        - Huifeng Guan讲得思路更清楚，但不做讲义；花花的讲义做得好。
        - Time is O(mn^2), Space is O(mn), will TLE for sure.
        - try Binary Search later
    */
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int[][] dp = new int[days+1][n];
        //pre sum
        int[] ps = new int[n];
        ps[0] = weights[0];
        for (int i = 1; i < n; i++) {
            ps[i] = ps[i-1] + weights[i];
        }
        //init
        for (int i = 1; i <= days; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                if (i == 1) {
                    dp[i][j] = ps[j];
                }
            }
        }

        //dp
        for (int i = 2; i <= days; i++) {
            //j need to be at least i-1 to split tasks
            for (int j = i-1; j < n; j++) {
                for (int k = 0; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i-1][k], (ps[j] - ps[k])));
                }
            }
        }
        return dp[days][n-1];
    }
}
