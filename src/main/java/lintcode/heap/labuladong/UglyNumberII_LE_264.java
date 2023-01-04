package lintcode.heap.labuladong;

import java.util.PriorityQueue;

public class UglyNumberII_LE_264 {
    /**
     1.4.2022
     - 微软系题目
     - 对于当前ugly number的某一个元素k，由它可以生成另外三个ugly number，分别是k*2,k*3,k*5，于是将这三个数添加进一个小顶堆的优先队列，自动冒出候选者中的最小值。注意需要做去重。因为每次弹出一个数，会加入三个数，这样的时间复杂度是o(3Nlog3N).
     - ref 管哥 post
     - 另有DP解法更高效，就是东哥post上解法
     */
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        heap.offer(1L);
        while (n > 0) {
            long cur = heap.poll();
            n--;
            if (n == 0) {
                return (int)cur;
            }

            // 去重
            while (heap.size() > 0 && heap.peek() == cur) {
                heap.poll();
            }

            heap.offer(cur * 2);
            heap.offer(cur * 3);
            heap.offer(cur * 5);
        }
        return -1;
    }
}
