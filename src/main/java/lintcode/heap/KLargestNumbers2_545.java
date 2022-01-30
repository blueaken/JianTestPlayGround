package lintcode.heap;

import java.util.*;

public class KLargestNumbers2_545 {
    //Note: PriorityQueue size is actually unbounded, even if it is contructed with a init size para.
    //Its size need be maintained during the process, if want to maintain the maxsize.

    private static Queue<Integer> minHeap;
    private int maxSize;

    /*
     * @param k: An integer
     */public KLargestNumbers2_545(int k) {
        // do intialization if necessary
        this.maxSize = k;
        this.minHeap = new PriorityQueue<>(maxSize);
    }

    /*
     * @param num: Number to be added
     * @return: nothing
     */
    public void add(int num) {
        // write your code here
        minHeap.offer(num);
        if (minHeap.size() > this.maxSize) {
            minHeap.poll();
        }
    }

    /*
     * @return: Top k element
     */
    public List<Integer> topk() {
        // write your code here
        List<Integer> res = new ArrayList<>(maxSize);
        Iterator<Integer> iterator = minHeap.iterator();
        while (iterator.hasNext()) {
            res.add(iterator.next());
        }
        Collections.reverse(res);
        return res;
    }
}
