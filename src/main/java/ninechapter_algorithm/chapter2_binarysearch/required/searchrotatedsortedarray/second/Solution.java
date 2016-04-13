package ninechapter_algorithm.chapter2_binarysearch.required.searchrotatedsortedarray.second;

/**
 * Author: blueaken
 * Date: 4/12/16 7:45 PM
 */
public class Solution {
    /**
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public static int search(int[] A, int target) {
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
                //right side sorted
                if (A[mid] < target && target <= A[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                //left side sorted
                if (A[mid] > target && target >= A[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return A[start] == target ? start : -1;
    }

    public static void main(String[] args){
//        int[] nums = {6,-3,1,2,3,4,5};//left
//        int[] nums = {4,5,6,7,8,9,10,11,12,-2,1,2,3};//right
        int[] nums = {4,5,6,-2,1,2,3};//middle
//        int[] nums = {1,2,3};
        System.out.println("location of the target is: "  + search(nums, -2));
    }
}
