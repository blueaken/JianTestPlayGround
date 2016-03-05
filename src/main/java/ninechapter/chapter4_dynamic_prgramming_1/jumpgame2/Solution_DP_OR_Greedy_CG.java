package ninechapter.chapter4_dynamic_prgramming_1.jumpgame2;

/**
 * Author: blueaken
 * Date: 3/3/16 11:04 AM
 */
public class Solution_DP_OR_Greedy_CG {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public static int jump(int[] A) {
        // wirte your code here
        if (A == null || A.length == 0) {
            return 0;
        }

        //init
        int reach = 0;
        int lastreach = 0;
        int step = 0;

        //dp it
        for (int i = 0; i <= reach && i < A.length; i++) {
            if (i > lastreach) {
                step++;
                lastreach = reach;
            }
            reach = Math.max(A[i] + i, reach);
        }

        if (reach < A.length - 1) {
            return 0;
        }
        return step;
    }

    public static void main(String[] args) {
//        int[] test = {2,3,1,1,4};
//        int[] test = {3,2,1,0,4};
        int[] test = {4,6,9,5,9,3,0};

        System.out.println(jump(test));
    }
}
