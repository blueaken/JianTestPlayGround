package ninechapter_algorithm.chapter2_binarysearch.optional.totaloccurence;

/**
 * Author: blueaken
 * Date: 4/13/16 9:02 AM
 */
public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public static int totalOccurrence(int[] A, int target) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
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

        int count = 0;
        if (A[start] != target) {
            return 0;
        } else {
            while (start < A.length && A[start++] == target) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] test = {1,1,1};
        int target = 1;

        System.out.println(totalOccurrence(test, target));
    }
}
