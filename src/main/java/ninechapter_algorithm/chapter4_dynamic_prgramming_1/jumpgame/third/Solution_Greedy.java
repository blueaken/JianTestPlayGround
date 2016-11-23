package ninechapter_algorithm.chapter4_dynamic_prgramming_1.jumpgame.third;

/**
 * Author: blueaken
 * Date: 7/2/16 11:21
 */
public class Solution_Greedy {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        if (A == null || A.length == 0) {
            return false;
        }

        int reach = 0;
        for (int i = 0; i < A.length && i <= reach; i++) {
            reach = Math.max(A[i] + i, reach);
        }
        return reach >= A.length - 1;
    }
}
