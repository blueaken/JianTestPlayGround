package ninechapter_algorithm.chapter4_dynamic_prgramming_1.climbStairs.second;

/**
 * Author: blueaken
 * Date: 4/6/16 9:54 AM
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
        int[] res = new int[n+1];
        res[0] = 1;
        res[1] = 1;

        //dp
        for (int i = 2; i <=n; i++) {
            res[i] = res[i-1] + res[i-2];
        }

        return res[n];
    }
}
