package ninechapter_algorithm.chapter2_binarysearch.required.searchrotatedsortedarray.third;

/**
 * Author: blueaken
 * Date: 6/22/16 10:21
 */
public class Solution {
    /**
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[mid] < A[end]) {
                //rightside sorted
                if (A[mid] < target && target <= A[end]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            } else {
                //leftside sorted
                if (A[mid] > target && target >= A[start]) {
                    end = mid - 1;
                } else {
                    start = mid;
                }
            }
        }
        return A[start] == target ? start : -1;
    }

    public static void main(String[] args) {
//        int[] test = {6,8,9,1,3,5};
//        int target = 5;

        int[] test = {4,3};
        int target = 3;

        Solution solution = new Solution();
        System.out.println(solution.search(test, target));
    }

}
