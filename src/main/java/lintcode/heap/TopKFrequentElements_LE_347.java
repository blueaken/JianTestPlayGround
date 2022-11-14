package lintcode.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements_LE_347 {
    /**
     ref 东哥 post
     similar to 215, need a hashtable to get the freq first
     */
    public int[] topKFrequent(int[] nums, int k) {
        //build freq map
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        //init heap in the ascending order of the freq and load the array
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> freq.get(a) - freq.get(b));
        for (int i : freq.keySet()) {
            heap.offer(i);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        //build the result
        int[]res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }
        return res;

    }
}
