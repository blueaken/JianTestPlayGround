package ninechapter_algorithm.chapter2_binarysearch.required.findpeaknumber.second;

/**
 * Author: blueaken
 * Date: 4/12/16 3:11 PM
 */
public class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public static int findPeak(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (A[mid] < A[mid+1]) {
                start = mid + 1;
            } else if (A[mid] < A[mid-1]) {
                end = mid;
            } else { // mid is the peak number
                return mid;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        int[] test = {1,2,6,8,9,1,3,4,5,7,6,0,9,7};

        System.out.println(findPeak(test));
    }


}
