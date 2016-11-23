package ninechapter_algorithm.chapter4_dynamic_prgramming_1.jumpgame2.third;

/**
 * Author: blueaken
 * Date: 7/2/16 11:48
 */
public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }

        //init
        int len = A.length;
        int[] res = new int[len];
        res[0] = 0;

        //dp
        for (int i = 1; i < len; i++) {
            res[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (res[j] != Integer.MAX_VALUE && (i - j) <= A[j]) {
                    res[i] = Math.min(res[j] + 1, res[i]);
                }
            }
        }
        return res[len - 1];
    }

}
