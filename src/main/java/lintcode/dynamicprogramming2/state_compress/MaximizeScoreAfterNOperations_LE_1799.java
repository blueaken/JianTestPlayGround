package lintcode.dynamicprogramming2.state_compress;

public class MaximizeScoreAfterNOperations_LE_1799 {
    /*
        - influenced by sense from recent working on bitmask problems
        - ref top down dfs solution - https://leetcode.com/problems/maximize-score-after-n-operations/discuss/1690800/Java-Standard-DFS-%2B-bitmask
    */
    public int maxScore(int[] nums) {
        int[] mem = new int[1 << nums.length]; //2^N - 1种状态
        return helper(nums, 1, 0, mem);
    }

    private int helper(int[] nums, int opTimes, int state, int[] mem) {
        if (mem[state] != 0) {
            return mem[state];
        }

        int n = nums.length;
        //only n/2 operations needed
        if (opTimes > n / 2) {
            return 0;
        }

        int max = 0;
        //search 2 bits not selected yet and calculate its score
        for (int i = 0; i < n; i++) {
            if ((state & (1 << i)) != 0) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if ((state & (1 << j)) != 0) {
                    continue;
                }
                int curScore = opTimes * gcd(nums[i], nums[j]);
                int nextState = state | (1 << i) | (1 << j);
                max = Math.max(max, curScore + helper(nums, opTimes + 1, nextState, mem));
            }
        }

        mem[state] = max;
        return mem[state];
    }

    private int gcd (int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }
}
