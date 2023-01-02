package lintcode.monotonicqueue;

import java.util.Arrays;
import java.util.LinkedList;

public class JumpGameVI_LE_1696_BottomUpDP_MonotonicQueue {

    /**
     1.2.2023
     - 1st try DP top down with memory optimize - TLE
     - 2nd try bottom up DP (preparing for optimizatioin with Monotonic Queue) - TLE
     - 3rd try bottom up DP optimized with Monotonic Queue - AC
     */

    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];

        MonotonicQueue1696 window = new MonotonicQueue1696();
        window.push(dp[0]);

        for (int p = 1; p < n; p++) {
            dp[p] = window.max() + nums[p];

            if (window.size() == k) {
                window.pop();
            }
            window.push(dp[p]);
        }

        return dp[n-1];
    }

}

class MonotonicQueue1696 {
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
