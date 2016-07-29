package ninechapter_algorithm.chapter7_array_and_number.mergesortedarray.third;

/**
 * Author: blueaken
 * Date: 7/27/16 09:36
 */
public class Solution {
    /**
     * @param A: sorted integer array A which has m elements,
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int index = m + n - 1;
        int indA = m - 1;
        int indB = n - 1;
        while (indA >= 0 && indB >= 0) {
            if (A[indA] > B[indB]) {
                A[index--] = A[indA--];
            } else {
                A[index--] = B[indB--];
            }
        }
        while (indB >= 0) {
            A[index--] = B[indB--];
        }
        return;
    }
}
