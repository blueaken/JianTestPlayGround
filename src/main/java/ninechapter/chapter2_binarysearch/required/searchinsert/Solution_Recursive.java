package ninechapter.chapter2_binarysearch.required.searchinsert;

/**
 * Author: blueaken
 * Date: 2/22/16 3:34 PM
 */
public class Solution_Recursive {

    public static int searchInsert(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }

        return rec(A, 0, A.length-1, target);
    }

    private static int rec (int[] A, int start, int end, int target){
        if (start >= end) {
            return A[start] < target ? start+1 : start;
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
        int[] test = {1,2,3,4,5,9};

//        int target = 5;

//        int target = 2;

//        int target = 7;

        int target = 0;

        System.out.println(searchInsert(test, target));
    }
}
