package ninechapter_algorithm.chapter4_dynamic_prgramming_1.climbStairs.third;

/**
 * Author: blueaken
 * Date: 7/1/16 15:36
 */
public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if (n < 2) {
            return 1;
        }

        //init
        int[] res = new int[n];
        res[0] = 1;
        res[1] = 2;

        //dp
        for (int i = 2; i < n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n - 1];
    }
}
