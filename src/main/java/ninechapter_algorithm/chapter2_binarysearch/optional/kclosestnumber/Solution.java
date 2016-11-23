package ninechapter_algorithm.chapter2_binarysearch.optional.kclosestnumber;

/**
 * Author: blueaken
 * Date: 4/13/16 11:16 AM
 */
public class Solution {
    /**
     * @param A an integer array
     * @param target an integer
     * @param k a non-negative integer
     * @return an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // Write your code here
        int[] result = new int[k];
        if (A == null || A.length == 0 || k > A.length) {
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

        //find first index
        int front, back;
        if (A[start] <= target || start == 0) {
            front = start;
            back = start + 1;
        } else {
            int cur = A[start] - target < target - A[start-1] ? start : start - 1;
            front = cur;
            back = cur + 1;
        }

        for (int i = 0; i < k; i++) {
            if (front >= 0 && back <= A.length - 1) {
                //find the closest candidate
                if (target - A[front] <= A[back] - target) {
                    result[i] = A[front--];
                } else {
                    result[i] = A[back++];
                }
            } else if (front >= 0) {
                //no more on the right side
                result[i] = A[front--];
            } else if (back <= A.length - 1) {
                //no more on the left side
                result[i] = A[back++];
            }
        }
        return result;
    }
}
