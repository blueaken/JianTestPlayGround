package lintcode.sort;

import java.util.Random;

public class SortAnArray_LE_912_QuickSort_P1 {
    /*
        11.09.2022
        solve with merge sort
        ==============
        11.11.2022
        redo with quick sort
        - note:quick sort 边界条件比较多比merge sort容易出错，注释参考东哥帖子
        - note:quick sort is not stable, comparing - merge sort is stable
        ==============
        2.25.2023
        - try with merge sort
        - Binary Tree Post Traverse like
        ==============
        2.27.2023
        - try with quick sort
        - Binary Tree Pre Traverse like
    */
    public int[] sortArray(int[] nums) {
        shuffle(nums);

        sort(nums, 0, nums.length - 1);
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

        // 关于区间的边界控制需格外小心，稍有不慎就会出错
        // 我这里把 i, j 定义为开区间，同时定义：
        // [lo, i) <= pivot；(j, hi] > pivot
        // 之后都要正确维护这个边界区间的定义
        int i = lo+1, j = hi;

        // 当 i > j时结束循环，确保 lo .. hi全覆盖
        while (i <= j) {
            while (i < hi && nums[i] <= pivot) {
                // i should stops with the 1st index greater than pivot
                i++;
            }
            while (j > lo && nums[j] > pivot) {
                // j should stops with the 1st index smaller or equal than pivot
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
        int n = nums.length;
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            // generate a random number between [i, n-1]
            int r = i + rand.nextInt(n-i);
            swap(nums, i, r);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
