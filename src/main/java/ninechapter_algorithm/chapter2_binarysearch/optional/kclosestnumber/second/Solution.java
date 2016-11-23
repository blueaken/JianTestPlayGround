package ninechapter_algorithm.chapter2_binarysearch.optional.kclosestnumber.second;

import java.util.Arrays;

/**
 * Author: blueaken
 * Date: 6/23/16 16:06
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
        if (A == null || A.length < k) {
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
        int left, right;
        if (A[start] <= target || start == 0) {
            left = start;
            right = start + 1;
        } else {
            int cur = A[start] - target < target - A[start - 1] ? start : start - 1;
            left = cur;
            right = cur + 1;
        }

        int count = 0;
        for (int i = 0; i < k && left >= 0 && right < A.length; i++) {
            //decide which side is closer
            if (Math.abs(target - A[left]) <= Math.abs(target - A[right])) {
                result[i] = A[left--];
            } else {
                result[i] = A[right++];
            }
            count++;
        }
        while (count < k) {
            if (left == -1) {
                //use all right side
                result[count++] = A[right++];
            } else if (right == A.length) {
                //use all left side
                result[count++] = A[left--];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {1,10,15,25,35,45,50,59};
        int target = 30;
        int k = 7;

        System.out.println(Arrays.toString(solution.kClosestNumbers(test, target, k)));
    }
}
