package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.other.quicksort;

import java.util.Arrays;

/**
 * Author: blueaken
 * Date: 2/29/16 4:24 PM
 */
public class Solution {
    public static int[] sort(int[] data){
        if (data == null || data.length < 2) {
            return data;
        }

        //1. divide
        int size = data.length;
        int pivotIndex = size / 2;
        int pivotValue = data[pivotIndex];

        int leftSize = 0;
        for (int i = 0; i < size; i++) {
            if (data[i] < pivotValue) {
                leftSize++;
            }
        }
        int[] left = new int[leftSize];
        int rightSize = size - leftSize - 1;
        int[] right = new int[rightSize];
        int l = 0, r = 0;
        for (int i = 0; i < size; i++) {
            if (i == pivotIndex) {
                continue;
            }
            if (data[i] < pivotValue) {
                left[l++] = data[i];
            } else {
                right[r++] = data[i];
            }
        }

        sort(left);
        sort(right);

        //2. conquer
        System.arraycopy(left, 0, data, 0, leftSize);
        data[leftSize] = pivotValue;
        System.arraycopy(right, 0, data, leftSize + 1, rightSize);

        return data;
    }

    public static void main(String[] args){
        int[] testArr = {3,45,57,23,15,39,78,22,23,23,23,23,23};
        System.out.println("after quick sort the array is: " + Arrays.toString(sort(testArr)));
    }
}
