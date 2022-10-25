package lintcode.dynamicprogramming2.keyboard;

public class FourKeyBoard_LE_651 {
    /*
        10.25.2022
        ref labaladong post
    */
    public int maxA(int n) {
        int dp[] = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i-1] + 1; //按A键
            for (int j = 2; j < i; j++) {
                int cur = dp[j-2] * (i-j+1);//全选 & 复制 dp[j-2], i - j + 1次
                dp[i] = Math.max(dp[i], cur);
            }
        }
        return dp[n];
    }
}
