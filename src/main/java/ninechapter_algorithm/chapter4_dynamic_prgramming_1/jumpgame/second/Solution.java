package ninechapter_algorithm.chapter4_dynamic_prgramming_1.jumpgame.second;

/**
 * Author: blueaken
 * Date: 4/6/16 2:53 PM
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
        int n = A.length;
        boolean[] res = new boolean[n];
        res[0] = true;

        //dp
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j ++) {
                if (res[j] && j + A[j] >= i) {
                    res[i] = true;
                    break;
                }
            }
        }

        return res[n-1];
    }

    public static void main(String[] args) {
//        int[] test = {2,3,1,1,4};
        int[] test = {3,2,1,0,4};
//        int[] test = {4,6,9,5,9,3,0};

        System.out.println(canJump(test));
    }
}
