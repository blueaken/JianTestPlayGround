package ninechapter_algorithm.chapter2_binarysearch.required.searchinsert;

/**
 * Author: blueaken
 * Date: 2/22/16 2:41 PM
 */
public class Solution_1st {
    public static int searchInsert(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }

        return rec(A, 0, A.length-1, target);
    }

    private static int rec (int[] A, int start, int end, int target){
        if (start > end) {
            if (end < 0){
                return start;
            }
            if (target > A[end]){
                return end+1;
            }
            return start;
        }

        int mid = (start + end) / 2;
        if (target == A[mid]) {
            return mid;
        }else if (target < A[mid]){
            return rec(A, start, mid-1, target);
        }

        return rec(A, mid+1, end, target);
    }

    public static void main(String[] args){
        int[] test = {1,3,5,6};

//        int target = 5;

        int target = 2;

//        int target = 7;

//        int target = 0;

        System.out.println(searchInsert(test, target));
    }
}
