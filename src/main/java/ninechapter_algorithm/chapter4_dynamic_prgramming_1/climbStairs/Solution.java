package ninechapter_algorithm.chapter4_dynamic_prgramming_1.climbStairs;

/**
 * Author: blueaken
 * Date: 3/2/16 9:45 AM
 */
public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public static int climbStairs(int n) {
        // write your code here
        if (n < 2) {
            return 1;
        }
        int[] solutions = new int[n+1];

        //init
        solutions[0] = 1;
        solutions[1] = 1;

        //dp it
        for (int i = 2; i <= n; i++) {
            solutions[i] = solutions[i-1] + solutions[i-2] ;
        }
        return solutions[n];
    }
}
