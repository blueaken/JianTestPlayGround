package ninechapter_algorithm.chapter2_binarysearch.required.searchinsert.second;

/**
 * Author: blueaken
 * Date: 4/12/16 9:56 AM
 */
public class Solution {
    /**
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }

        int start = 0;
        int end = A.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return A[start] < target ? start + 1 : start;
    }
}
