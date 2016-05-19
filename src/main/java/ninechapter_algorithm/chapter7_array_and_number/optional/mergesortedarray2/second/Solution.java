package ninechapter_algorithm.chapter7_array_and_number.optional.mergesortedarray2.second;

/**
 * Author: blueaken
 * Date: 5/19/16 09:53
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
        int[] result = new int[lenA + lenB];
        int i = 0; int j = 0; int k = 0;
        while (i < lenA && j < lenB) {
            if (A[i] < B[j]) {
                result[k++] = A[i++];
            } else {
                result[k++] = B[j++];
            }
        }
        while (i < lenA) {
            result[k++] = A[i++];
        }
        while (j < lenB) {
            result[k++] = B[j++];
        }

        return result;
    }
}
