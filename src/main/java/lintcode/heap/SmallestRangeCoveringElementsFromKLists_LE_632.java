package lintcode.heap;

import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeCoveringElementsFromKLists_LE_632 {
    /*
       ref HFG - https://www.youtube.com/watch?v=ejVD92bJe34 and get the idea, but how to implement in Java still need consideration
       - each range is selected from current smallest of each list, so as each range:
       1. a is the smallest
       2. this range covers all lists
       - after that, pop the smallest of the range
       - the list is already sorted, use index to keep track of the smallest of each
       - use a Heap to sort each range and find the smallest
       - Time is O(N) + O(klogk) , N - the number of total elements
       ==============================================================================
       9.15.22
       - ref https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/discuss/2266286/Java-Siple-Solution-oror-Priority-Queue-oror-97-faster
       - get the idea how to implement in Java
   */
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int curMax = -100000;

        //load 1st element of each lists
        for (int i = 0; i < k; i++) {
            List<Integer> list = nums.get(i);
            int curVal = list.get(0);
            curMax = Math.max(curMax, curVal);

            int[] tuple = {curVal, 0, i}; //value, list idx, nums idx
            minHeap.offer(tuple);
        }

        //iteratate each element
        int[] ans = {-100000, 100000}; // ref problem Constrains
        while (true) {
            int[] min = minHeap.poll();
            if ((curMax - min[0]) < (ans[1] - ans[0])) {
                ans[0] = min[0];
                ans[1] = curMax;
            }

            List<Integer> list = nums.get(min[2]);
            int curListIdx = min[1] + 1;
            if (curListIdx == list.size()) {
                break;
            } else {
                min[0] = list.get(curListIdx);
                min[1] = curListIdx;
                minHeap.offer(min);
                curMax = Math.max(curMax, min[0]);
            }
        }
        return ans;
    }
}
