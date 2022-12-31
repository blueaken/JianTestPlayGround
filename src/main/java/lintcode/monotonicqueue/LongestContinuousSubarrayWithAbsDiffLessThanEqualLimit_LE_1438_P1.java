package lintcode.monotonicqueue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class LongestContinuousSubarrayWithAbsDiffLessThanEqualLimit_LE_1438_P1 {
    /*
        ref problem hint - using two pointer
        Time - O(NogN), each poll operation is O(logN), for N nodes, is O(NLogN)
        Space - O(N)
        ===========================
        12.31.2022 P1
        refactor with Monotonic Queue after 东哥 post
        - with 滑动窗口框架
    */
    public int longestSubarray(int[] nums, int limit) {
        MonotonicQueue window = new MonotonicQueue();

        int left = 0, right = 0;
        int windowSize = 0, ans = 0;
        while (right < nums.length) {
            window.push(nums[right]);
            right++;
            windowSize++;

            while (window.getMax() - window.getMin() > limit) {
                window.pop(nums[left]);
                left++;
                windowSize--;
            }
            ans = Math.max(ans, windowSize);
        }
        return ans;
    }

    class MonotonicQueue {
        LinkedList<Integer> maxq = new LinkedList<>();
        LinkedList<Integer> minq = new LinkedList<>();

        void push(int n) {
            while (maxq.size() > 0 && maxq.peekLast() < n) {
                maxq.pollLast();
            }
            maxq.offerLast(n);

            while (minq.size() > 0 && minq.peekLast() > n) {
                minq.pollLast();
            }
            minq.offerLast(n);
        }

        int getMax() {
            return maxq.peekFirst();
        }

        int getMin() {
            return minq.peekFirst();
        }

        void pop(int n) {
            if (n == maxq.peekFirst()) {
                maxq.pollFirst();
            }

            if (n == minq.peekFirst()) {
                minq.pollFirst();
            }
        }

    }

    public static void main(String[] args) {
        LongestContinuousSubarrayWithAbsDiffLessThanEqualLimit_LE_1438_P1 solution = new LongestContinuousSubarrayWithAbsDiffLessThanEqualLimit_LE_1438_P1();
//        int[] nums = {8,2,4,7};
//        int limit = 4;
//        //2

//        int[] nums = {10,1,2,4,7,2};
//        int limit = 5;
//        //4

        int[] nums = {4,2,2,2,4,4,2,2};
        int limit = 0;
        //3

        System.out.println(solution.longestSubarray(nums, limit));
    }
}
