package ninechapter_algorithm.chapter8_data_structure.topklargestnumbers;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Author: blueaken
 * Date: 6/6/16 13:43
 */
public class Solution_SpaceSizeK {
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        // Write your code here
        if (nums == null || nums.length < k) {
            return null;
        }
        int[] res = new int[k];

        Queue<Integer> minHeap = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            if (minHeap.size() < k) {
                minHeap.add(nums[i]);
            } else if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }

        //output in reverse order
        for (int i = k - 1; i >= 0; i--) {
            res[i] = minHeap.poll();
        }
        return res;
    }
}
