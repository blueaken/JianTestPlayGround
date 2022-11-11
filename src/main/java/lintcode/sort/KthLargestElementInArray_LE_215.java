package lintcode.sort;

import java.util.Random;

public class KthLargestElementInArray_LE_215 {
    /**
     11.11.2022
     ref 东哥 post
     it can be solved with PriorityQueue but it is not challenging with Quick Select Sort
     */
    public int findKthLargest(int[] nums, int k) {
        // shuffle(nums);

        //将问题转化为第n -k大的元素
        k = nums.length - k;
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int p = partition(nums, lo, hi);
            if (p < k) {
                lo = p+1;
            } else if (p > k) {
                hi = p-1;
            } else {
                return nums[p];
            }
        }
        return -1;
    }

    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        int i = lo+1, j = hi;
        while (i <= j) {
            while (i < hi && nums[i] <= pivot) {
                i++;
            }
            while (j > lo && nums[j] > pivot) {
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

    private void shuffle(int[] nums) {
        Random rand = new Random();
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int r = i + (rand.nextInt(n-i));
            swap(nums, i, r);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
