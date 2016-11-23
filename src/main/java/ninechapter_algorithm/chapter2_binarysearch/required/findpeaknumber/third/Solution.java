package ninechapter_algorithm.chapter2_binarysearch.required.findpeaknumber.third;

/**
 * Author: blueaken
 * Date: 6/23/16 11:14
 */
public class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        if (A == null || A.length < 3) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (A[mid] < A[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
