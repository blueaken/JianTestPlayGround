package lintcode.design.random;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray_LE_384 {
    /**
     1.14.2023
     ref 东哥 post
     */
    int[] nums;
    Random rand = new Random();

    public ShuffleAnArray_LE_384(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int n = nums.length;
        int[] copy = Arrays.copyOf(nums, n);
        for (int i = 0; i < n; i++) {
            // generate an index between [i, n-1]
            int r = i + rand.nextInt(n-i);
            swap(copy, i, r);
        }
        return copy;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
