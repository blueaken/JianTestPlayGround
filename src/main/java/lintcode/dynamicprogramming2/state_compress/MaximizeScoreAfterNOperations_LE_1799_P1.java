package lintcode.dynamicprogramming2.state_compress;

public class MaximizeScoreAfterNOperations_LE_1799_P1 {
    /*
        - influenced by sense from recent working on bitmask problems
        - ref top down dfs soluiton - https://leetcode.com/problems/maximize-score-after-n-operations/discuss/1690800/Java-Standard-DFS-%2B-bitmask
        ========================================
        P1 10.13.2022
        - ref prev notes
        - Java bit operator - https://www.cnblogs.com/hongten/p/hongten_java_yiweiyunsuangfu.html
    */
    public int maxScore(int[] nums) {
        int n = nums.length;
        int[] mem = new int[1 << n]; //2^n-1 states
        return helper(nums, 1, 0, mem);
    }

    private int helper (int[] nums, int opsTimes, int state, int[] mem) {
        if (mem[state] != 0) {
            return mem[state];
        }

        int n = nums.length;
        if (opsTimes > n / 2) {
            return 0;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if ((state & (1 << i)) != 0) {
                continue;
            }
            for (int j = i+1; j < n; j++) {
                if ((state & (1 << j)) != 0) {
                    continue;
                }
                int curScore = opsTimes * gcd(nums[i], nums[j]);
                int nextState = state | (1 << i) | (1 << j);
                max = Math.max(max, curScore + helper(nums, opsTimes+1, nextState, mem));
            }
        }
        mem[state] = max;
        return mem[state];
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }
}
