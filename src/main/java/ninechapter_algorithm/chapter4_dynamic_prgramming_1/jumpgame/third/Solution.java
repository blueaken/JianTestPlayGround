package ninechapter_algorithm.chapter4_dynamic_prgramming_1.jumpgame.third;

/**
 * Author: blueaken
 * Date: 7/2/16 11:15
 */
public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        if (A == null || A.length == 0) {
            return false;
        }

        //init
        boolean[] res = new boolean[A.length];
        res[0] = true;

        //dp
        for (int i = 1; i < A.length; i ++) {
            for (int j = 0; j < i; j++) {
                if (res[j] && (i - j) <= A[j]) {
                    res[i] = true;
                    break;
                }
            }
        }
        return res[A.length - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] test = {2,3,1,1,4};
//        int[] test = {3,2,1,0,4};
        int[] test = {1, 0};

        System.out.println(solution.canJump(test));
    }
}
