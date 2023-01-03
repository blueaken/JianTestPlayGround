package lintcode.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums_LE_373 {
    /**
     1.3.2023
     - 使用PriorityQueue处理排序和加入next Pair,来避免O(m*n)循环
     - similar to LE 23
     - ref 东哥 post
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 存储三元组 int[] - {nums1[i], nums2[i], index of nums2}
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            return (a[0] + a[1]) - (b[0] + b[1]);
        });

        // init heap value
        for (int i = 0; i < nums1.length; i++) {
            heap.offer(new int[] {nums1[i], nums2[0], 0});
        }

        List<List<Integer>> res = new ArrayList<>();
        while (heap.size() > 0 && k > 0) {
            int[] cur = heap.poll();
            k--;
            int next = cur[2] + 1;

            if (next < nums2.length) {
                heap.offer(new int[] {cur[0], nums2[next], next});
            }

            List<Integer> pair = new ArrayList<>();
            pair.add(cur[0]);
            pair.add(cur[1]);
            res.add(pair);
        }
        return res;
    }
}
