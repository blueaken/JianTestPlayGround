package lintcode.twopointers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class AdvantageShuffle_LE_870 {
    /**
     12.14.2022
     - ref 东哥 post, 田忌赛马策略
     - 因为nums 2顺序不能改变，使用Priority Queue来辅助
     */
    public int[] advantageCount(int[] nums1, int[] nums2) {
        //descending sort nums2 and keep its index
        PriorityQueue<int[]> heap = new PriorityQueue<>((int[] a, int[] b) -> {
            return b[1] - a[1];
        });

        int n = nums2.length;
        for (int i = 0; i < n; i++) {
            heap.offer(new int[]{i, nums2[i]});
        }

        //ascending sort nums1
        Arrays.sort(nums1);

        int[] res = new int[n];
        int left = 0, right = n - 1;
        while (heap.size() > 0) {
            int[] cur = heap.poll();
            int idx = cur[0], maxVal = cur[1];
            if (nums1[right] > maxVal) {
                //nums1中元素干得过就自己干
                res[idx] = nums1[right];
                right--;
            } else {
                //干不过就找个垫底的送人头
                res[idx] = nums1[left];
                left++;
            }
        }
        return res;
    }
}
