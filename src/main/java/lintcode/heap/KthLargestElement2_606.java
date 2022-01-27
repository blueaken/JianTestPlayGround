package lintcode.heap;

import java.util.PriorityQueue;

public class KthLargestElement2_606 {
    /**
     * @param nums an integer unsorted array
     * @param k an integer from 1 to n
     * @return the kth largest element
     */
    //Idea:
    // 1. 如果 N 和 K 在一个数量级上，采用 quickSelect 来解题，如果 N >> K，采用 PriorityQueue 来解题
    // 2. 最小堆要保持堆内元素个数在 k 个，这样可以保证执行 minHeap.peek() 时得到的是第 k 大的元素
    public int kthLargestElement2(int[] nums, int k) {
        // Write your code here
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for (int num : nums) {
            q.offer(num);
            if (q.size() > k) {
                q.poll();
            }
        }
        return q.peek();
    }
}
