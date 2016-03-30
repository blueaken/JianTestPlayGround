package ninechapter.chapter4_dynamic_prgramming_1.jumpgame;

/**
 * Author: blueaken
 * Date: 3/2/16 6:23 PM
 */
public class Solution_DP_CG {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public static boolean canJump(int[] A) {
        // wirte your code here
        if (A == null || A.length == 0) {
            return false;
        }

        int reach = 0;
        for (int i = 0; i <= reach && i < A.length; i++) {
            reach = Math.max(A[i] + i, reach);
        }

        return reach >= A.length - 1;
    }

    public static void main(String[] args) {
//        int[] test = {2,3,1,1,4};
//        int[] test = {3,2,1,0,4};
        int[] test = {4,6,9,5,9,3,0};

        System.out.println(canJump(test));
    }
}
