package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.other.mergesort;

import java.util.Arrays;

/**
 * Author: blueaken
 * Date: 2/29/16 3:34 PM
 */
public class Solution {

    public static int[] sort(int[] data){
        if (data == null || data.length < 2) {
            return data;
        }

        //1. divide
        int size = data.length;
        int mid = size / 2;
        int[] left = Arrays.copyOfRange(data, 0, mid);
        int[] right = Arrays.copyOfRange(data, mid, size);

        sort(left);
        sort(right);

        //2. conquer
        return merge(data, left, right);
    }

    private static int[] merge(int[] data, int[] left, int[] right) {
        int i = 0, l =0 , r = 0;
        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                data[i++] = left[l++];
            } else {
                data[i++] = right[r++];
            }
        }
        while (l < left.length) {
            data[i++] = left[l++];
        }
        while (r < right.length) {
            data[i++] = right[r++];
        }

        return data;
    }

    public static void main(String[] args){
        int[] testArr = {3,45,57,23,15,39,78,22,23};
        System.out.println("after merge sort the array is: " + Arrays.toString(sort(testArr)));
    }
}
