package lintcode.heap.labuladong;

import java.util.PriorityQueue;

public class KthLargestElementInStream_LE_703 {
    /**
     1.5.2022
     try PriorityQueue solution
     */

    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int k;

    public KthLargestElementInStream_LE_703(int k, int[] nums) {
        this.k = k;
        for (int i : nums) {
            heap.offer(i);
            if (heap.size() > k) {
                heap.poll();
            }
        }
    }

    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k) {
            heap.poll();
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums = {2, 4, 5, 8};
        KthLargestElementInStream_LE_703 solution = new KthLargestElementInStream_LE_703(k, nums);
        System.out.println(solution.add(3)); //4
        System.out.println(solution.add(5)); //5
        System.out.println(solution.add(10)); //5
        System.out.println(solution.add(9)); //8
        System.out.println(solution.add(4)); //8
    }
}
