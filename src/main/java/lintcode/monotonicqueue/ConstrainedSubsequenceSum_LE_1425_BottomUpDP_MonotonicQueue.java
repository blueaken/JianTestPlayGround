package lintcode.monotonicqueue;

import java.util.LinkedList;

public class ConstrainedSubsequenceSum_LE_1425_BottomUpDP_MonotonicQueue {
    /**
     1.2.2023
     - similar to 1696, the diff is 1696 must start from nums[0]
     - try with Longest Increasing SubSequence Bottom Up DP - TLE
     - try bottom up DP optimized with Monotonic Queue
     */
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        MonotonicQueue1425 window = new MonotonicQueue1425();
        window.push(dp[0]);

        int res = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], window.max() + nums[i]);
            if (window.size() == k) {
                window.pop();
            }
            window.push(dp[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

class MonotonicQueue1425 {
    LinkedList<Integer> q = new LinkedList<>();
    LinkedList<Integer> maxq = new LinkedList<>();

    int size() {
        return q.size();
    }

    void push(int n) {
        q.offerLast(n);

        while (maxq.size() > 0 && maxq.peekLast() < n) {
            maxq.pollLast();
        }
        maxq.offerLast(n);
    }

    void pop() {
        Integer val = q.pollFirst();
        if (val != null && val.equals(maxq.peekFirst())) {
            maxq.pollFirst();
        }
    }

    int max() {
        return maxq.peekFirst();
    }
}