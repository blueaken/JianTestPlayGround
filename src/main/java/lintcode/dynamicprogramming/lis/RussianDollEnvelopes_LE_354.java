package lintcode.dynamicprogramming.lis;

import java.util.Arrays;

public class RussianDollEnvelopes_LE_354 {
    /*
    10.17.2022
    read labuladong post and redo
    - bottom up DP
    - 1st INC sort on width, if width equals then DEC sort on height
    - find the LIS on the sorted height, which is the answer
    */
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            int diff = a[0] - b[0];
            if (diff == 0) {
                return b[1] - a[1];
            }
            return diff;
        });

        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            heights[i] = envelopes[i][1];
        }

        //find the LIS of heights array
        int[] dp = new int[heights.length];
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            dp[i] = 1; //base case
            for (int j = 0; j < i; j++) {
                if (heights[i] > heights[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
