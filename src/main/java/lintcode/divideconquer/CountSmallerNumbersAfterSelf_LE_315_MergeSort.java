package lintcode.divideconquer;

import java.util.ArrayList;
import java.util.List;

public class CountSmallerNumbersAfterSelf_LE_315_MergeSort {
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

        //load nums array val and id into Pair array
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        sort(arr, 0, n-1);

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(count[i]);
        }
        return res;
    }

    private void sort(Pair[] arr, int lo, int hi) {
        //base case - no need to sort one element array
        if (lo == hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(arr, lo, mid);
        sort(arr, mid+1, hi);

        merge(arr, lo, mid, hi);
    }

    private void merge(Pair[] arr, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            temp[i] = arr[i];
        }

        int i = lo, j = mid+1;
        for (int pos = lo; pos <= hi; pos++) {
            if (i == mid+1) {
                arr[pos] = temp[j++];
            } else if (j == hi+1) {
                arr[pos] = temp[i++];
                //every time there is an update in i, we should update the count array
                int oriId = arr[pos].id;
                count[oriId] += j - (mid + 1);
            } else if (temp[i].val > temp[j].val) {
                arr[pos] = temp[j++];
            } else {
                //note - if duplicate value, we should update the count array too
                arr[pos] = temp[i++];
                //every time there is an update in i, we should update the count array
                int oriId = arr[pos].id;
                count[oriId] += j - (mid + 1);
            }
        }
    }
}
