package ninechapter_algorithm.chapter7_array_and_number.mergesortedarray.second;

/**
 * Author: blueaken
 * Date: 5/19/16 09:43
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
        int index = m + n - 1; int iA = m - 1; int iB = n - 1;
        while (iA >= 0 && iB >= 0) {
            if (A[iA] > B[iB]) {
                A[index--] = A[iA--];
            } else {
                A[index--] = B[iB--];
            }
        }
        while (iB >= 0) {
            A[index--] = B[iB--];
        }
        return;
    }
}
