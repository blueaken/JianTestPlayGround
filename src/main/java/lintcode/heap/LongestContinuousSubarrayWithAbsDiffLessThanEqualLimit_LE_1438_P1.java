package lintcode.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LongestContinuousSubarrayWithAbsDiffLessThanEqualLimit_LE_1438_P1 {
    /*
        ref problem hint - using two pointer
        Time - O(NogN), each poll operation is O(logN), for N nodes, is O(NLogN)
        Space - O(N)
    */
    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int start = 0, end = 0;
        int ans = 0;
        minHeap.offer(nums[0]);
        maxHeap.offer(nums[0]);
        while (start <= end && end < nums.length) {
            int diff = maxHeap.peek() - minHeap.peek();
            if (diff <= limit) {
                end++;
                ans = Math.max(ans, minHeap.size());
                if (end < nums.length) {
                    minHeap.offer(nums[end]);
                    maxHeap.offer(nums[end]);
                    continue;
                }
            } else {
                minHeap.remove(nums[start]);
                maxHeap.remove(nums[start]);
                start++;
            }
        }
        return ans;
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
