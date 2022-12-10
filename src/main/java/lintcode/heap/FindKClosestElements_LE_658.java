package lintcode.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosestElements_LE_658 {
    /**
     12.10.2022
     - gut feeling is Priority Queue with customer comparator
     - O(nlogn + klogk)
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> {
            int diff = Math.abs(a - x) - Math.abs(b - x);
            if (diff == 0) {
                diff = a - b;
            }
            return diff;
        });
        for (int i : arr) {
            heap.offer(i);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(heap.poll());
        }
        Collections.sort(res);

        return res;
    }
}
