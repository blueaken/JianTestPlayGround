package ninechapter_algorithm.chapter8_data_structure.optional.topklargestnumbers2;

import java.util.*;

/**
 * Author: blueaken
 * Date: 6/6/16 10:22
 */
public class Solution {
    private static PriorityQueue<Integer> minHeap;
    private int maxSize;

    public Solution(int k) {
        // initialize your data structure here.
        this.maxSize = k;
        this.minHeap = new PriorityQueue<>(k);
    }

    public void add(int num) {
        // Write your code here
        if (minHeap.size() < maxSize) {
            minHeap.add(num);
        } else if (num > minHeap.peek()) {
            minHeap.poll();
            minHeap.add(num);
        }
    }

    public List<Integer> topk() {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        Iterator<Integer> iterator = minHeap.iterator();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }

    public static void main(String[] args) {
        /*
         expect:
            [10,3]
            [1000,10,3]
            [1000,10,4]
            [1000,100,10]
         */
        Solution solution = new Solution(3);
        solution.add(3);
        solution.add(10);
        System.out.println(solution.topk());
        solution.add(1000);
        solution.add(-99);
        System.out.println(solution.topk());
        solution.add(4);
        System.out.println(solution.topk());
        solution.add(100);
        System.out.println(solution.topk());
    }
}