package ninechapter_algorithm.chapter7_array_and_number.optional.mergesortedarray2;

/**
 * Author: blueaken
 * Date: 4/26/16 1:49 PM
 */
public class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // Write your code here
        if (A == null || A.length == 0) {
            return B;
        }
        if (B == null || B.length == 0) {
            return A;
        }

        int lenA = A.length;
        int lenB = B.length;
        int len = lenA + lenB;

        int[] res = new int[len];
        int idxA = 0;
        int idxB = 0;
        int idx = 0;
        while (idxA < lenA && idxB < lenB) {
            if (A[idxA] <= B[idxB]) {
                res[idx++] = A[idxA++];
            } else {
                res[idx++] = B[idxB++];
            }
        }
        while (idxA < lenA) {
            res[idx++] = A[idxA++];
        }
        while (idxB < lenB) {
            res[idx++] = B[idxB++];
        }
        return res;
    }
}
