package ninechapter_algorithm.chapter2_binarysearch.optional.searchrotatedsortedarray2;

/**
 * Author: blueaken
 * Date: 4/13/16 4:09 PM
 */
public class Solution {
    /**
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean
     */
    public static boolean search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return false;
        }

        int start = 0;
        int end = A.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return true;
            }
            if (A[mid] > A[start]) {
                //left side sorted
                if (A[start] <= target && target < A[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (A[mid] < A[start]) {
                //right side sorted
                if (A[mid] < target && target <= A[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                //A[start] == A[mid] == A[end]
                start++;
            }
        }

        return A[start] == target;
    }

    public static void main(String[] args) {
        int target = 3;
        int[] test = {3,4,4,5,7,0,1,1,1,2};

        System.out.println(search(test, target));
    }
}
