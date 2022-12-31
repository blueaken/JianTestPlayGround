package lintcode.monotonicqueue;

import java.util.LinkedList;

public class SlidingWindowMaximum_LE_239_P1 {
    /**
     12.31.2022
     - refactor with Monotonic Queue ref 东哥 post
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();

        int size = nums.length;
        int[] res = new int[size - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                // 先填满前 k-1 个元素
                window.push(nums[i]);
            } else {
                window.push(nums[i]);
                res[i-k+1] = window.getMax();
                window.pop(nums[i-k+1]);
            }
        }
        return res;
    }
}

class MonotonicQueue {
    LinkedList<Integer> maxq = new LinkedList<>();

    void push(int n) {
        while (maxq.size() > 0 && maxq.getLast() < n) {
            maxq.removeLast();
        }
        maxq.addLast(n);
    }

    int getMax() {
        return maxq.getFirst();
    }

    void pop(int n) {
        // n can be popped in the push operation, so need to compare first
        if (n == maxq.getFirst()) {
            maxq.removeFirst();
        }
    }
}
