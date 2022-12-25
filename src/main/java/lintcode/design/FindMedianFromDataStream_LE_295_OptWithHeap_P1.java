package lintcode.design;

import java.util.PriorityQueue;

/*
    - gut shot idea, no optimization, got TLE
    - ref 花花 https://zxi.mytechroad.com/blog/leetcode/leetcode-295-find-median-from-data-stream/
    - Optimize wtih 2 heaps, minHeap and maxHeap, maintain the maxHeap size >= minHeap size, and the diff < 2;
    ===================================
    12.25.2022
    redo ref 东哥 post
*/
public class FindMedianFromDataStream_LE_295_OptWithHeap_P1 {
    int count = 0;
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    public FindMedianFromDataStream_LE_295_OptWithHeap_P1() {
        small = new PriorityQueue<>((a, b) -> b - a);
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        //ensure small size >= large & the diff < 2
        if (small.size() > large.size()) {
            small.offer(num);
            large.offer(small.poll());
        } else {
            large.offer(num);
            small.offer(large.poll());
        }
        count++;
    }

    public double findMedian() {
        boolean isEven = count % 2 == 0;
        if (isEven) {
            return (double)(small.peek() + large.peek()) / 2;
        } else {
            return (double)small.peek();
        }
    }
}
