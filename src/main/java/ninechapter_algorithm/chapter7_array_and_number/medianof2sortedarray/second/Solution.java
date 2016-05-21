package ninechapter_algorithm.chapter7_array_and_number.medianof2sortedarray.second;

/**
 * Author: blueaken
 * Date: 5/20/16 17:48
 */
public class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int len = A.length + B.length;
        if (len % 2 == 1) {
            return findKth(A, 0, B, 0, len / 2 + 1);
        } else {
            return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2;
        }
    }

    private double findKth(int[] A, int startA, int[] B, int startB, int k) {
        if (startA >= A.length) {
            return B[startB + k - 1];
        }
        if (startB >= B.length) {
            return A[startA + k - 1];
        }
        if (k == 1) {
            return Math.min(A[startA], B[startB]);
        }

        int A_key = startA + k / 2 - 1 < A.length
                ? A[startA + k / 2 - 1] : Integer.MAX_VALUE;
        int B_key = startB + k / 2 - 1 < B.length
                ? B[startB + k / 2 - 1] : Integer.MAX_VALUE;

        if (A_key == B_key) {
            return A_key;
        } else if (A_key < B_key) {
            return findKth(A, startA + k / 2, B, startB, k - k / 2);
        } else {
            return findKth(A, startA, B, startB + k / 2, k - k / 2);
        }
    }

    public static void main(String[] args) {
        //tc1: expect 3
//        int[] A = {1,2,3};
//        int[] B = {4,5};

        //tc2: expect 3.5
        int[] A = {1,2,3,4,5,6};
        int[] B = {2,3,4,5};

        //tc3: expect 6.0
        //good test case: cover both of the following case
        // 1. when the number diff of two arrays are big, at this time Integer.MAX_VALUE of the small array will play
        // which puts the small array out of the compare before their number are close
        // 2. when A_start is out of scope of A array, at this time use B array directly
//        int[] A = {1,2};
//        int[] B = {2,3,4,5,6,7,8,9,10,11,12};

        Solution solution = new Solution();

        System.out.println(solution.findMedianSortedArrays(A, B));
    }
}
