package sort;

/**
 * Author: blueaken
 * Date: 6/29/14 1:19 下午
 */
public class RotatedSortedArray {
    public static int search(int[] A, int target) {
        int len = A.length;
        if (len == 0) return -1;

        int pivot = -999;
        //found the pivot position
        for (int i=0; i<len-1; i++){
            if (A[i] < A[i+1]) continue;
            pivot = i+1;
            break;
        }

        //if pivot not found then just binary search the original array
        if (pivot == -999){
            return binarySearch(A, 0, len-1, target);
        }

        //if pivot is found then take it as 2 sorted array 0..pivot-1 and pivot..len-1 and do the binary search in the 2 array respectively according to the target value
        if (target <= A[pivot-1] && target >= A[0]) return binarySearch(A, 0, pivot-1, target);

        if (target <= A[len-1] && target >= A[pivot]) return binarySearch(A, pivot, len-1, target);

        return -1;
    }

    private static int binarySearch(int[] A, int start, int end, int target){
        if (start > end) return -1;
        int mid = start + (end - start)/2;
        if (target == A[mid]) return mid;
        if (target > A[mid]) return binarySearch(A, mid+1, end, target);
        return binarySearch(A, start, mid-1, target);
    }

    public static void main(String[] args){
//        int[] rotatedArr = {3,4,5,6,7,9,0,1,2};
        int[] rotatedArr = {1};
        int target = 1;
        int index = search(rotatedArr, target);
        System.out.println("target " + target + " index is: " + index);
    }
}
