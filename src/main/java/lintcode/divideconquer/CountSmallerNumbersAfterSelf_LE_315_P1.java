package lintcode.divideconquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSmallerNumbersAfterSelf_LE_315_P1 {
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
          use a sorted array to help, so as to use binary search                                                                      =================================
    */

    public List<Integer> countSmaller(int[] nums) {
        int[] count = new int[nums.length];
        int[] sorted = Arrays.copyOfRange(nums, 0, nums.length);

        helper(nums, sorted, 0, nums.length - 1, count);

        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            ret.add(count[i]);
        }
        return ret;
    }

    private void helper(int[] nums, int[] sorted, int start, int end, int[] count) {
        if (start >= end) {
            return; //if start == end, smaller number after nums[start] is 0, which is the default, no need to further processed
        }

        int mid = (start + end) / 2;
        helper(nums, sorted, start, mid, count);
        helper(nums, sorted, mid+1, end, count);

        //additional work for the left half
        for (int i = start; i <= mid; i++) {
            int lowerBound = binarySearch(sorted, mid+1, end, nums[i]); //similar to C++ lowerBound()
            count[i] += lowerBound - (mid + 1);
        }

        Arrays.sort(sorted, start, end + 1);
    }

    //二分查找数组中等于key的位置，找到返回该数字的最小地址，不存在则give the upper bound of key
    public int binarySearch(int arr[], int low, int high, int key){
        while(low < high){
            int mid = low + (high - low)/2;
            if(arr[mid] >= key){
                high = mid;
            } else{
                low = mid+1;
            }
        }

        //不存在则give the upper bound of key
        if (arr[low] < key) {
            low++;
        }
        return low;
    }

    public static void main(String[] args) {
        CountSmallerNumbersAfterSelf_LE_315_P1 solution = new CountSmallerNumbersAfterSelf_LE_315_P1();
        int[] nums = {5,2,6,1};
        System.out.println(solution.countSmaller(nums)); //{2,1,1,0}
    }
}
