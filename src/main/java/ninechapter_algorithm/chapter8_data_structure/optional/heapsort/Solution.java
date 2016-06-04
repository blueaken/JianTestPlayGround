package ninechapter_algorithm.chapter8_data_structure.optional.heapsort;

import java.util.Arrays;

/**
 * Author: blueaken
 * Date: 6/4/16 10:00
 */
public class Solution {
    /**
     * @param A: Given an integer array
     * @return: int[]
     */
    private int heapSize;

    public int[] heapSort(int[] A) {
        // write your code here
        if (A == null || A.length < 2) {
            return A;
        }

        heapify(A);
        for (int i = A.length - 1; i >= 0; i--) {
            swap(A, 0, i);
            heapSize--;
            sinkDown(A, 0);
        }
        return A;
    }

    private void heapify(int[] A) {
        // write your code here
        if (A == null || A.length < 2) {
            return;
        }

        heapSize = A.length;
        for (int i = heapSize / 2; i >= 0; i--) {
            sinkDown(A, i);
        }
        return;
    }

    private void sinkDown(int[] A, int parent) {
        while (parent < heapSize) {
            int smallest = parent;
            int left = 2 * parent + 1;
            int right = 2 * parent + 2;

            if (left < heapSize && A[left] < A[smallest]) {
                smallest = left;
            }
            if (right < heapSize && A[right] < A[smallest]) {
                smallest = right;
            }
            if (smallest == parent) {
                break;
            }

            swap(A, parent, smallest);
            //recursively sinkDown
            parent = smallest;
        }
        return;
    }

    private void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }

    public static void main(String[] args) {
        int[] test = {4,1,14,8,7};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.heapSort(test)));
    }
}
