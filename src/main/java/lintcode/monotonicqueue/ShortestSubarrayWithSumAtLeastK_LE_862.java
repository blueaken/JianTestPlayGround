package lintcode.monotonicqueue;

import java.util.LinkedList;

public class ShortestSubarrayWithSumAtLeastK_LE_862 {
    /**
     1.1.2023
     - Hard level，需要使用滑动窗口 + 前缀后数组 + 单调队列综合在一起
     - ref 东哥 post
     */
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        // 看题目的数据范围，前缀和数组中元素可能非常大，所以用 long 类型
        long[] ps = new long[n+1];
        for (int i = 1; i <= n; i++) {
            ps[i] = ps[i-1] + nums[i-1];
        }

        // 单调队列结构辅助滑动窗口算法
        MonotonicQueue862 window = new MonotonicQueue862();
        int left = 0, right = 0;
        int len = Integer.MAX_VALUE;
        while (right < ps.length) {
            // 扩大窗口，元素入队
            window.push(ps[right]);
            right++;

            // 若新进入窗口的元素和窗口中的最小值之差大于等于 k，
            // 说明得到了符合条件的子数组，缩小窗口，使子数组长度尽可能小 (要想想理解一下)
            while (right < ps.length && !window.isEmpty()
                    && ps[right] - window.min() >= k) {
                len = Math.min(len, right - left);
                window.pop(ps[left]);
                left++;
            }
        }
        return len == Integer.MAX_VALUE ? -1 : len;
    }

    public static void main(String[] args) {
        ShortestSubarrayWithSumAtLeastK_LE_862 solution = new ShortestSubarrayWithSumAtLeastK_LE_862();
        int[] nums = {2,-1,2,1,3};
        int k = 4;
        System.out.println(solution.shortestSubarray(nums, k));
    }
}


class MonotonicQueue862 {
    LinkedList<Long> minq = new LinkedList<>();

    void push(long n) {
        while (minq.size() > 0 && minq.peekLast() > n) {
            minq.pollLast();
        }
        minq.offerLast(n);
    }

    long min() {
        return minq.peekFirst();
    }

    void pop(long n) {
        if (n == minq.peekFirst()) {
            minq.pollFirst();
        }
    }

    boolean isEmpty() {
        // 如要计算size应该应该专门设立一个queue，但本方法只要求是否为空，就用minq的size()了
        return minq.size() == 0;
    }
}
