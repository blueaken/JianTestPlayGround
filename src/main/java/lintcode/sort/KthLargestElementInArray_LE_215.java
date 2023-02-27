package lintcode.sort;

import java.util.Random;

public class KthLargestElementInArray_LE_215 {
    /**
     11.11.2022
     ref 东哥 post
     it can be solved with PriorityQueue but it is not challenging with Quick Select Sort, O(N)
     ================
     1.5.2023
     try the PriorityQueue solution, O(NlogK)
     ================
     2.27.2023
     try the quick sort + binary search solution, 东哥 template
     */
    public int findKthLargest(int[] nums, int k) {
        // shuffle(nums);

        // 相当于找第n-k个元素, 升序
        k = nums.length - k;
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int p = partition(nums, lo, hi);
            if (p < k) {
                lo = p + 1;
            } else if (p > k) {
                hi = p - 1;
            } else {
                return nums[k];
            }
        }
        return -1;
    }

    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        int i = lo + 1, j = hi;
        while (i <= j) {
            while (i < nums.length && nums[i] <= pivot) {
                i++;
            }
            while (j > 0 && nums[j] > pivot) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
