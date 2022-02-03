package lintcode.heap;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumCost_1872 {
    /**
     * @param sticks: the length of sticks
     * @return: Minimum Cost to Connect Sticks
     */
    //Idea: the min cost plan should start from the 2 min cost bars and so on ...
    public int MinimumCost(List<Integer> sticks) {
        // write your code here
        if (sticks.size() < 2) {
            return 0;
        }

        Queue<Integer> minHeap = new PriorityQueue<>();
        for (Integer i : sticks) {
            minHeap.offer(i);
        }

        int sum = 0;
        while (minHeap.size() > 0) {
            int cost = minHeap.poll() + minHeap.poll();
            sum += cost;
            if (minHeap.size() == 0) {
                break;
            }
            minHeap.offer(cost);
        }
        return sum;
    }
}
