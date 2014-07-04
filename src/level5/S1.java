package level5;

import java.util.Arrays;

/**
 * Author: blueaken
 * Date: 7/3/14 2:53 下午
 */
public class S1 {
    public static double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;

        if (m+n == 0) return -999;//not found

//        if (isEven(m+n)){
//            return (findKthSortedArrays_merge(A, B, (m + n) / 2) + findKthSortedArrays_merge(A, B, (m + n) / 2 + 1))/2;
//        } else {
//            return findKthSortedArrays_merge(A, B, (m + n) / 2 + 1);
//        }

        if (isEven(m+n)){
            return (findKthSortedArrays_index_binary(A, B, (m + n) / 2) + findKthSortedArrays_index_binary(A, B, (m + n) / 2 + 1))/2;
        } else {
            return findKthSortedArrays_index_binary(A, B, (m + n) / 2 + 1);
        }

    }

    private static double findKthSortedArrays_merge(int A[], int B[], int k){
        int m = A.length;
        int n = B.length;

        if ((m+n)<k) return -999;//not found

        int[] result = new int[m+n];

        int a = 0;
        int b = 0;
        int r = 0;
        while (a<m && b<n){
            if (A[a] < B[b]) {
                result[r++] = A[a++];
            } else{
                result[r++] = B[b++];
            }
        }

        while (a<m){
            result[r++] = A[a++];
        }

        while (b<n){
            result[r++] = B[b++];
        }

        return result[k-1];

    }

    private static double findKthSortedArrays_index_binary(int A[], int B[], int k){
        int m = A.length;
        int n = B.length;

        //always assume that m is equal or smaller than n
        if (m > n)
            return findKthSortedArrays_index_binary(B, A, k);

        if (m == 0)
            return B[k - 1];

        if (k == 1)
            return (A[0]<B[0] ? A[0]:B[0]);

        //divide k into two parts
        int pa = (k/2<m ? k/2:m);
//        int pa = k/2;
        int pb = k - pa;

        if (A[pa - 1] < B[pb - 1])
            return findKthSortedArrays_index_binary(Arrays.copyOfRange(A, pa, m), B, k - pa);
        else if (A[pa - 1] > B[pb - 1])
            return findKthSortedArrays_index_binary(A, Arrays.copyOfRange(B, pb, n), k - pb);
        else
            return A[pa - 1];

    }

    private static boolean isEven(int num){
        return (num % 2 == 0);
    }

    public static void main (String[] args){
//        int[] testA = {5,8,100,106,207};
//        int[] testB = {1,2,3,4,13,96,97};

        int[] testA = {1};
        int[] testB = {2,3,4,5,6};

        double median = findMedianSortedArrays(testA, testB);
        System.out.println("median of combined array is: " + median);
    }

}
