package ninechapter_algorithm.chapter2_binarysearch.required.findpeaknumber;

/**
 * Author: blueaken
 * Date: 2/25/16 8:53 AM
 */
public class Solution_Concise {
    public static int findPeak(int[] A) {
        int left = 0;
        int right = A.length - 1;
        while (left < right){
            int mid = (left + right) / 2;
            if (A[mid] > A[mid+1]){
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args){
        int[] test = {1,2,1,3,4,5,7,6};
//        int[] test = {1,2};

        System.out.println(findPeak(test));
    }
}
