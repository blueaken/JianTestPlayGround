package ninechapter_algorithm.chapter2_binarysearch.required.searchforrange.second;

import java.util.Arrays;

/**
 * Author: blueaken
 * Date: 4/12/16 9:12 PM
 */
public class Solution {
    /**
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public static int[] searchRange(int[] A, int target) {
        // write your code here
        int[] res = new int[2];
        int leftbound = -1;
        int rightbound = -1;
        res[0] = leftbound;
        res[1] = rightbound;

        if (A == null || A.length == 0) {
            return res;
        }

        int start = 0;
        int end = A.length - 1;

        //left bound
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (A[mid] == target) {
                end = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[start] == target) {
            leftbound = start;
        } else if (A[end] == target) {
            leftbound = end;
        }
        //else lbound init is -1;

        //right bound
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (A[mid] == target) {
                start = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[end] == target) {
            rightbound = end;
        } else if (A[start] == target) {
            rightbound = start;
        }
        //else rbound init is -1;

        res[0] = leftbound;
        res[1] = rightbound;

        return res;
    }

    public static void main(String[] args){
//        int[] test = {5, 7, 7, 8, 8, 10};
//        int target = 8;

//        int[] test = {1};
//        int target = 1;

          int[] test = {5,5,5,5,5,5,5,5,5,5};
          int target = 5;

//        int[] test = {0,1,1,1,1,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,4,10,10,10,10,10,10,10,10,10,10,10,10,10,20,20,101,202,304,509,10001};
//        int target = 10;


        System.out.println(Arrays.toString(searchRange(test, target)));
    }
}
