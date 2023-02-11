package lintcode.slidewindow;

import java.util.PriorityQueue;

public class MaximumNumberOfRobotsWithinBudget_LE_2398_BinarySearch {
    /**
     ref wisdompeak github
     - binary search + sliding window
     ====================
     2.10.2023
     - redo with 东哥 sliding window template, with priority queue
     - also ref solution post - https://leetcode.com/problems/maximum-number-of-robots-within-budget/solutions/2524813/sliding-window-and-priority-queue/
     - Time - O(NLogN), Space - O(N)
     =====================
     2.11.2023
     - previous solution ACed, but only beat 10% time, should be able to optimize with binary search
     - TLE in the performance test case
     */
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length;
        long left = 0, right = n;
        // use 东哥 right bound template
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (isOk(mid, chargeTimes, runningCosts, budget)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left - 1 < 0) {
            return 0;
        }
        return (int)(left - 1);
    }

    private boolean isOk(long k, int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length;
        int left = 0, right = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        long sum = 0l;

        while (right < n) {
            pq.offer(chargeTimes[right]);
            sum += runningCosts[right];
            right++;

            if (pq.size() == (int)k) {
                if ((pq.peek() + pq.size() * sum) <= budget) {
                    return true;
                }
                pq.remove(chargeTimes[left]);
                sum -= runningCosts[left];
                left++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        MaximumNumberOfRobotsWithinBudget_LE_2398_BinarySearch solution = new MaximumNumberOfRobotsWithinBudget_LE_2398_BinarySearch();
        int[] chargeTimes = {8,76,74,9,75,71,71,42,15,58,88,38,56,59,10,11};
        int[] runningCosts = {1,92,41,63,22,37,37,8,68,97,39,59,45,50,29,37};
        int budget = 412;
        // 3

//        int[] chargeTimes = {11,12,19};
//        int[] runningCosts = {10,8,7};
//        int budget = 19;
//        // 0


        System.out.println(solution.maximumRobots(chargeTimes, runningCosts, budget));

    }
}
