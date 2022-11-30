package lintcode.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn_LE_740 {
    /**
     11.30.2022
     ref https://leetcode.com/problems/delete-and-earn/solutions/1818112/delete-and-earn/
     solve by bottom up DP
     */
    public int deleteAndEarn(int[] nums) {
        int maxNum = 0;

        Map<Integer, Integer> points = new HashMap<>();
        for (int num : nums) {
            int val = points.getOrDefault(num, 0);
            points.put(num, val + num);

            maxNum = Math.max(maxNum, num);
        }

        int[] dp = new int[maxNum+1];
        dp[1] = points.getOrDefault(1, 0);

        for (int num = 2; num <= maxNum; num++) {
            int gain = points.getOrDefault(num, 0);
            dp[num] = Math.max(dp[num-1], gain + dp[num-2]);
        }
        return dp[maxNum];
    }
}
