package lintcode.sort;

import java.util.Random;

public class SortAnArray_LE_912_QuickSort {
    /*
        11.09.2022
        solve with merge sort
        ==============
        11.11.2022
        redo with quick sort
        - note:quick sort 边界条件比较多比merge sort容易出错，注释参考东哥帖子
        ==============
    */
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        //shuffle first in case chances of link list like partition
        shuffle(nums);

        sort(nums, 0, n-1);
        return nums;
    }

    private void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int p = partition(nums, lo, hi);
        sort(nums, lo, p-1);
        sort(nums, p+1, hi);
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
        for (int i = 0; i < n; i++) {
            int r = i + rand.nextInt(n-i);
            swap(nums, i, r);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
