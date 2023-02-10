package lintcode.slidewindow;

import java.util.PriorityQueue;

public class MaximumNumberOfRobotsWithinBudget_LE_2398 {
    /**
     ref wisdompeak github
     - binary search + sliding window
     ====================
     2.10.2023
     - redo with 东哥 sliding window template, with priority queue
     - also ref solution post - https://leetcode.com/problems/maximum-number-of-robots-within-budget/solutions/2524813/sliding-window-and-priority-queue/
     - Time - O(NLogN), Space - O(N)
     */
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length;
        int left = 0, right = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int res = Integer.MIN_VALUE;
        long sum = 0l;

        while (right < n) {
            pq.offer(chargeTimes[right]);
            sum += runningCosts[right];
            right++;

            while (pq.size() > 0 && ((pq.peek() + pq.size() * sum)) > budget) {
                pq.remove(chargeTimes[left]);
                sum -= runningCosts[left];
                left++;
            }
            res = Math.max(res, pq.size());
        }

        return res;
    }
}
