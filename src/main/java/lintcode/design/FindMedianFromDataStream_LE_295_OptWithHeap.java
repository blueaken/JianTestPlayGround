package lintcode.design;

import java.util.PriorityQueue;

/*
    - gut shot idea, no optimization, got TLE
    - ref 花花 https://zxi.mytechroad.com/blog/leetcode/leetcode-295-find-median-from-data-stream/
    - Optimize with 2 heaps, minHeap and maxHeap, maintain the maxHeap size >= minHeap size, and the diff < 2;
*/
public class FindMedianFromDataStream_LE_295_OptWithHeap {
    private PriorityQueue<Integer> leftH; //store the left half of the data stream
    private PriorityQueue<Integer> rightH; //store the right half of the data stream
    private int count;

    public FindMedianFromDataStream_LE_295_OptWithHeap() {
        this.leftH = new PriorityQueue<>((a, b) -> b - a);
        this.rightH = new PriorityQueue<>();
        this.count = 0;
    }

    //O(logN) per input, to the data stream is O(NLogN)
    public void addNum(int num) {
        // add new num
        leftH.offer(num);
        rightH.offer(leftH.poll()); //balance the previous step

        // balance the size, to make left heap size >= right heap size && diff < 2
        if (leftH.size() < rightH.size()) {
            leftH.offer((rightH.poll()));
        }
        count++;
    }

    //O(1)
    public double findMedian() {
        boolean isEven = count % 2 == 0;
        if (isEven) {
            return (double)(leftH.peek() + rightH.peek()) / 2;
        } else {
            return (double)(leftH.peek());
        }
    }

    public static void main(String[] args) {
        FindMedianFromDataStream_LE_295_OptWithHeap solution = new FindMedianFromDataStream_LE_295_OptWithHeap();
        solution.addNum(1);
        solution.addNum(2);
        System.out.println(solution.findMedian()); //1.50
        solution.addNum(3);
        System.out.println(solution.findMedian()); //2.00
        solution.addNum(4);
        System.out.println(solution.findMedian()); //2.50
        solution.addNum(5);
        System.out.println(solution.findMedian()); //3.00

//        solution.addNum(-1);
//        System.out.println(solution.findMedian()); //-1.00
//        solution.addNum(-2);
//        System.out.println(solution.findMedian()); //-1.50
//        solution.addNum(-3);
//        System.out.println(solution.findMedian()); //-2.00
//        solution.addNum(-4);
//        System.out.println(solution.findMedian()); //-2.50
//        solution.addNum(-5);
//        System.out.println(solution.findMedian()); //-3.00
    }
}
