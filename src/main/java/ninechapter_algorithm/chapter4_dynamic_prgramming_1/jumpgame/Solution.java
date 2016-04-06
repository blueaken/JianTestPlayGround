package ninechapter_algorithm.chapter4_dynamic_prgramming_1.jumpgame;

/**
 * Author: blueaken
 * Date: 3/2/16 5:07 PM
 */
public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public static boolean canJump(int[] A) {
        // wirte your code here
        if (A == null || A.length == 0) {
            return false;
        }

        //init
        boolean[] result = new boolean[A.length];
        result[0] = true;

        //dp it
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (result[j] && ((i - j) <= A[j])){
                    result[i] = true;
                    break;
                }
            }
        }
        return result[A.length-1];
    }

    public static void main(String[] args) {
//        int[] test = {2,3,1,1,4};
//        int[] test = {3,2,1,0,4};
        int[] test = {4,6,9,5,9,3,0};

        System.out.println(canJump(test));
    }
}
