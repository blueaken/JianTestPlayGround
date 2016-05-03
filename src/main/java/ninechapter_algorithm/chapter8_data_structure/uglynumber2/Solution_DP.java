package ninechapter_algorithm.chapter8_data_structure.uglynumber2;

/**
 * Author: blueaken
 * Date: 5/3/16 12:03
 */
public class Solution_DP {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public static int nthUglyNumber(int n) {
        // Write your code here
        if(n == 1) {
            return 1;
        }

        int[] dp = new int[n+1]; // dp[i] holds the ith's ugly number
        dp[1] = 1;
        int p2=1, p3=1, p5=1;  // current index of 2/3/5 factor
        for(int i=2; i<=n; i++){
            // the next ugly number must be built from a smaller ugly number
            dp[i] = Math.min(2 * dp[p2], Math.min(3 * dp[p3], 5 * dp[p5]));
            if(dp[i] == 2 * dp[p2]) {
                p2++;
            }
            if(dp[i] == 3 * dp[p3]) {
                p3++;
            }
            if(dp[i] == 5 * dp[p5]) {
                p5++;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 20;

        System.out.println(nthUglyNumber(n));
    }
}
