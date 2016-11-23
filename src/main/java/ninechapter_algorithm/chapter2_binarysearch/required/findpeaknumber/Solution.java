package ninechapter_algorithm.chapter2_binarysearch.required.findpeaknumber;

/**
 * Author: blueaken
 * Date: 2/25/16 12:36 AM
 */
public class Solution {
    public static int findPeak(int[] A) {
        int left = 0;
        int right = A.length - 1;
        while (left < right){
            int mid = (left + right) / 2;
            if (isBiggerThanLeft(A, mid) && isBiggerThanRight(A, mid)){
                return mid;
            }
            if (isBiggerThanLeft(A, mid)){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private static boolean isBiggerThanRight(int[] A, int index){
        return index == A.length-1 || A[index] > A[index+1];
    }

    private static boolean isBiggerThanLeft(int[] A, int index){
        return index == 0 || A[index] > A[index-1];
    }

    public static void main(String[] args){
        //int[] test = {1,2,1,3,4,5,7,6};
        int[] test = {1,2};

        System.out.println(findPeak(test));
    }
}
