package ninechapter_algorithm.chapter8_data_structure.optional.medianindatastream;

import java.util.Comparator;
import java.util.PriorityQueue;

class MaxComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        return b - a;
    }
}

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return nums;
        }

        PriorityQueue<Integer> minHeap
                = new PriorityQueue<>(nums.length);
        PriorityQueue<Integer> maxHeap
                = new PriorityQueue<>(nums.length, new MaxComparator());
        int[] result = new int[nums.length];
        int tempMean = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                tempMean = nums[i];
            } else {
                //find median with min and max heap
                if (nums[i] < tempMean) {
                    maxHeap.add(nums[i]);
                    if (maxHeap.size() > minHeap.size()) {
                        minHeap.add(tempMean);
                        tempMean = maxHeap.poll();
                    }
                } else {
                    minHeap.add(nums[i]);
                    if (minHeap.size() - maxHeap.size() > 1) {
                        maxHeap.add(tempMean);
                        tempMean = minHeap.poll();
                    }
                }
            }
            result[i] = tempMean;
        }
        return result;
    }
}
