package ninechapter_algorithm.chapter2_binarysearch.optional.closetnumber;

/**
 * Author: blueaken
 * Date: 4/13/16 9:23 AM
 */
public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int closestNumber(int[] A, int target) {
        // Write your code here
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (A[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        if (A[start] <= target || start == 0) {
            return start;
        } else {
            return A[start] - target < target - A[start-1] ? start : start - 1;
        }
    }
}
