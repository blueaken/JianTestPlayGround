package ninechapter_algorithm.chapter2_binarysearch.optional.lastpositionbs;

/**
 * Author: blueaken
 * Date: 4/12/16 10:29 AM
 */
public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int lastPosition(int[] A, int target) {
        // Write your code here
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (A[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (A[end] == target) {
            return end;
        }
        if (A[start] == target) {
            return start;
        }

        return -1;
    }
}
