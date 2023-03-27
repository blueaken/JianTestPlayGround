package lintcode.twopointers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class AdvantageShuffle_LE_870_P1 {
    /**
     12.14.2022
     - ref 东哥 post, 田忌赛马策略
     - 因为结果要按照nums2的顺序，使用Priority Queue来辅助记录num2的索引位置
     ========================
     03.27.2023
     P1
     */
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Arrays.sort(nums1);
        // sort nums2 and keep its index
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < n; i++) {
            pq.offer(new int[] {i, nums2[i]});
        }

        int[] res = new int[n];
        int left = 0, right = n-1;
        while (pq.size() > 0) {
            int[] cur = pq.poll();
            int idx = cur[0];
            int curNums2Val = cur[1];
            if (nums1[right] > curNums2Val) {
                res[idx] = nums1[right];
                right--;
            } else {
                res[idx]= nums1[left];
                left++;
            }
        }
        return res;
    }
}
