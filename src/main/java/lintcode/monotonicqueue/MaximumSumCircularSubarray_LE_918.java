package lintcode.monotonicqueue;

import java.util.LinkedList;

public class MaximumSumCircularSubarray_LE_918 {
    /**
     1.1.2023
     - similar to 862, use 前缀和 + 单调队列
     - ref 东哥 post
     */
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        // 模拟环状的 nums 数组
        int[] ps = new int[2*n+1];
        // 计算环状 nums 的前缀和
        for (int i = 1; i < ps.length; i++) {
            ps[i] = ps[i-1] + nums[(i-1) % n];
        }

        MonotonicQueue918 window = new MonotonicQueue918();
        int ans = Integer.MIN_VALUE;
        window.push(0);
        for (int i = 1; i < ps.length; i++) {
            ans = Math.max(ans, ps[i] - window.min());

            // 维护窗口的大小为 nums 数组的大小
            if (window.size() == n) {
                window.pop();
            }
            window.push(ps[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumSumCircularSubarray_LE_918 solution = new MaximumSumCircularSubarray_LE_918();
        int[] nums = {1,-2,3,-2};
        System.out.println(solution.maxSubarraySumCircular(nums));
    }
}

class MonotonicQueue918 {
    LinkedList<Integer> q = new LinkedList<>();
    LinkedList<Integer> minq = new LinkedList<>();

    boolean isEmpty() {
        return q.size() == 0;
    }

    int size() {
        return q.size();
    }

    void push(int n) {
        q.addLast(n);

        while (minq.size() > 0 && minq.peekLast() > n) {
            minq.pollLast();
        }
        minq.offerLast(n);
    }

    void pop() {
        Integer val = q.pollFirst();

        if (val != null && val.equals(minq.peekFirst())) {
            minq.pollFirst();
        }
    }

    int min() {
        return minq.peekFirst();
    }
}