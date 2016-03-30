package ninechapter.chapter4_dynamic_prgramming_1.climbStairs;

/**
 * Author: blueaken
 * Date: 3/5/16 9:46 AM
 */
public class Solution_OptimizeSpace {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public static int climbStairs(int n) {
        // write your code here
        if (n < 2) {
            return 1;
        }

        //init
        int p = 1;
        int pp = 1;
        int result = 0;

        //dp it
        for (int i = 2; i <= n; i++) {
            result = p + pp;
            pp = p;
            p = result;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 3;

        System.out.println(climbStairs(n));
    }
}
