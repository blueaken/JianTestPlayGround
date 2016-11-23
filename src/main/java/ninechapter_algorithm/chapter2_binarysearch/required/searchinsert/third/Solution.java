package ninechapter_algorithm.chapter2_binarysearch.required.searchinsert.third;

/**
 * Author: blueaken
 * Date: 6/21/16 09:39
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

        //if target found, start
        //if target in the range, start
        //if target out of the right range, start + 1
        //if target out of the left range, start
        return target > A[A.length - 1] ? start + 1 : start;
    }
}
