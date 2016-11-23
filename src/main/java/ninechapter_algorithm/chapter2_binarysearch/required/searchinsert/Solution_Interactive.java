package ninechapter_algorithm.chapter2_binarysearch.required.searchinsert;

/**
 * Author: blueaken
 * Date: 2/22/16 3:34 PM
 */
public class Solution_Interactive {
    /**
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public static int searchInsert(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }

        int start = 0;
        int end = A.length-1;
        while (start < end){
            int mid = (start + end) / 2;
            if (A[mid] == target){
                return mid;
            } else if (A[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return A[start] < target ? start + 1 : start;
    }

    public static void main(String[] args){
        int[] test = {1,3,5,6};

//        int target = 5;

//        int target = 2;

//        int target = 7;

        int target = 0;

        System.out.println(searchInsert(test, target));
    }
}
