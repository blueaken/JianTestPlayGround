package leetcode.algorithm.dp.climbingstairs;

/**
 * Created by jshe18 on 7/11/15.
 */
public class Solution {
    public int climbStairs(int n) {
        if (n<3){
            return n;
        }

        int p = 2;
        int pp = 1;

        int result = 0;
        for (int i=3; i<=n; i++){
            result = p + pp;
            pp = p;
            p = result;
        }

        return result;
    }
}
