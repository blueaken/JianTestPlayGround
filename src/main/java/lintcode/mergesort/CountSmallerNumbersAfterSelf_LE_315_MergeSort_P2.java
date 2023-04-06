package lintcode.mergesort;

import java.util.ArrayList;
import java.util.List;

public class CountSmallerNumbersAfterSelf_LE_315_MergeSort_P2 {
    /*
        ref Huifeng Guan video again
        - https://www.youtube.com/watch?v=z-uLlQMvOVM
        - Divide & Conquer Then Merge Sort
        - similar to 1649
        - if Time is not very strict, can use Arrays.sort() directly to replace Merge Sort
        =================================

        A: [W W W W W W W W W W W W W W W]
           [Y Y Y Y Y Y Y Z Z Z Z Z Z Z Z]
            a                           b

        B: [Y Y Y Y Y Y Y]     [Z Z Z Z Z Z Z Z]
            a           mid  mid+1            b

          + additional work of update [Y Y Y Y Y Y Y]  , to found its relative position and update,
                                       a           mid
          use a sorted array to help, so as to use binary search
        =================================
        11.09.2022
        ref labuladong post - good idea of solving with merge sort
        =================================
        2.26.2023
        redo with merge sort, 东哥模板
        =================================
        04.06.2023
        P1
        =================================
    */

    class Pair {
        int val;
        int id;

        Pair(int val, int id) {
            this.val = val;
            this.id = id;
        }
    }

    Pair[] temp;
    int[] count;
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        temp = new Pair[n];
        count = new int[n];

        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        sortArray(arr, 0, n-1);

        List<Integer> res = new ArrayList<>();
        for (int c : count) {
            res.add(c);
        }
        return res;
    }

    private void sortArray(Pair[] arr, int lo, int hi) {
        if (hi == lo) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sortArray(arr, lo, mid);
        sortArray(arr, mid+1, hi);

        merge(arr, lo, mid, hi);
    }

    private void merge(Pair[] arr, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            temp[i] = arr[i];
        }

        int i = lo, j = mid+1;
        for (int po = lo; po <= hi; po++) {
            if (i == mid+1) {
                arr[po] = temp[j++];
            } else if (j == hi+1) {
                arr[po] = temp[i++];
                // update count when left subarry selected
                int oriId = arr[po].id;
                count[oriId] += j - (mid+1);
            } else if (temp[i].val > temp[j].val) {
                arr[po] = temp[j++];
            } else {
                // note - if duplicate we should update the count array too, since we know the count as well
                arr[po] = temp[i++];
                // update count when left subarry selected
                int oriId = arr[po].id;
                count[oriId] += j - (mid+1);
            }
        }

    }

    public static void main(String[] args) {
        CountSmallerNumbersAfterSelf_LE_315_MergeSort_P2 solution = new CountSmallerNumbersAfterSelf_LE_315_MergeSort_P2();
        int[] nums = {5,2,6,1}; //[2,1,1,0]
        System.out.println(solution.countSmaller(nums));
    }
}
