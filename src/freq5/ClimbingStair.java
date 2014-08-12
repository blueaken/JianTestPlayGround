package freq5;

import java.util.Arrays;

/**
 * Author: blueaken
 * Date: 8/11/14 4:43 下午
 */
public class ClimbingStair {
    public static int climbStairs(int n) {
        // dp数组，用来保存结果，可以适当开大一些
        int[] dp = new int[n+5];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        return rec(n, dp);
    }

    // 递归+dp
    private static int rec(int n, int[] dp){
        if(dp[n] != -1){
            return dp[n];
        }else{
            dp[n] = rec(n-1, dp) + rec(n-2, dp);
            return dp[n];
        }
    }
                   /*
                   * this is my first solution using recursive, it works correctly but time limit exceed. figure it out
                   * should use DP's memory skill above to avoid calc same result multiple times:
                    * "if(dp[n] != -1){ return dp[n];} "
                    */
//    public static int climbStairs(int n) {
//        if (n == 0) return 0;
//
//        return rec(n);
//    }
//
//    static int rec(int n){
//       int count;
//       if (n == 1){
//           return 1;
//       }
//
//       if (n == 2){
//           return 2;
//       }
//
//       count = rec(n-1) + rec(n-2);
//
//        return count;
//    }

    public static void main(String[] args){
        int result = climbStairs(5);
        System.out.println(result);
    }
}
