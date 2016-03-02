package ninechapter.chapter4_dynamic_prgramming_1.climbStairs;

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
        if (n == 0) {
            return 1;
        }
        if (n < 3) {
            return n;
        }
        int[] solutions = new int[n+1];

        //init
        solutions[1] = 1;
        solutions[2] = 2;

        //dp it
        for (int i = 3; i <= n; i++) {
            solutions[i] = solutions[i-1] + solutions[i-2] ;
        }

        return solutions[n];
    }

    public static void main(String[] args) {
        int test = 5;
        System.out.println(climbStairs(test));
    }
}
