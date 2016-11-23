package ninechapter_algorithm.chapter8_data_structure.optional.heapify.second;

/**
 * Author: blueaken
 * Date: 6/4/16 09:25
 */
public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        // write your code here
        if (A == null || A.length < 2) {
            return;
        }

        for (int i = A.length / 2; i >= 0; i--) {
            sinkDown(A, i);
        }
        return;
    }

    private void sinkDown(int[] A, int parent) {
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

            //swap
            int temp = A[parent];
            A[parent] = A[smallest];
            A[smallest] = temp;

            //keep sinkDown
            parent = smallest;
        }
        return;
    }

}
