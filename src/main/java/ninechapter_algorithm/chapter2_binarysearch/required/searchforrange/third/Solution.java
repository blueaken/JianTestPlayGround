package ninechapter_algorithm.chapter2_binarysearch.required.searchforrange.third;

/**
 * Author: blueaken
 * Date: 6/23/16 12:07
 */
public class Solution {
    /**
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if (A == null || A.length == 0) {
            return result;
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
        result[0] = A[start] == target ? start : -1;
        if (result[0] != -1) {
            while (start < A.length && A[start] == target) {
                start++;
            }
            result[1] = start - 1;
        }

        return result;
    }
}
