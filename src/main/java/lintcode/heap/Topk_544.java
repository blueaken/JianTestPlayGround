package lintcode.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class Topk_544 {
    /**
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */
    //Idea：直接用max heap做, 如要用min heap可以参考 https://www.lintcode.com/problem/544/solution/19905
    public int[] topk(int[] nums, int k) {
        // write your code here
        if (k > nums.length) {
            return new int[0];
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            maxHeap.offer(nums[i]);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll();
        }
        return res;
    }
}
