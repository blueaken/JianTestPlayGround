package ninechapter_algorithm.chapter2_binarysearch.required.searchforrange.third;

import java.util.Arrays;

/**
 * Author: blueaken
 * Date: 6/23/16 17:31
 */
public class Solution_TryWithAllCleanBookTemplate {
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
            //use nine chapter template to search right bound if target is found
            start = 0;
            end = A.length - 1;
            while (start + 1 < end) {
                int mid = (start + end) / 2;
                if (A[mid] <= target) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            if (A[end] == target) {
                result[1] = end;
            } else if (A[start] == target) {
                result[1] = start;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_TryWithAllCleanBookTemplate solution = new Solution_TryWithAllCleanBookTemplate();
        int[] test = {9,10,100,101,1002,10203};
        int target = 10203;

        System.out.println(Arrays.toString(solution.searchRange(test, target)));
    }
}
