package ninechapter_algorithm.chapter8_data_structure.optional.heapify;

import java.util.Arrays;

/**
 * Author: blueaken
 * Date: 5/2/16 22:53
 */
public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public static void heapify(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return;
        }

        for (int i = A.length / 2; i >= 0; i--) {
            sinkDown(A, i);
        }
        return;
    }

    private static void sinkDown(int[] A, int parent) {
        while (parent < A.length) {
            int smallest = parent;
            int left = 2 * parent + 1;
            int right = 2 * parent + 2;

            if (left < A.length && A[left] < A[smallest]) {
                smallest = left;
            }
            if (right < A.length && A[right] < A[smallest]) {
                smallest = right;
            }
            if (smallest == parent) {
                break;
            }

            swap(A, parent, smallest);
            parent = smallest;
        }
        return;
    }

    private static void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }

    public static void main(String[] args) {
        //expect 1,2,3,4,5
//        int[] test = {3,2,1,4,5};

        int[] test = {45,39,32,11};

        heapify(test);
        System.out.println(Arrays.toString(test));
    }
}
