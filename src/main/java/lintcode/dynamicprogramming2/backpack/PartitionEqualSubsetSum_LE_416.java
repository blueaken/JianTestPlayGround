package lintcode.dynamicprogramming2.backpack;

public class PartitionEqualSubsetSum_LE_416 {
    /*
        ref labaladong post
        - a viariation of 0/1 backpack
        - notice the diff with unlimited backpack problem (518. coin change 2), where
          dp[i][j - nums[i-1]], versus here, dp[i-1] - nums[j - nums[i-1]].
    */
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;

        boolean[][] dp = new boolean[n+1][target+1];
        //init
        for (int i = 0; i <= n; i++) {
            //if target is 0 then any partition can satisfy.
            dp[i][0] = true;
        }

        //dp
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                int cur = nums[i-1];
                if (j < cur) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-cur];
                }
            }
        }
        return dp[n][target];
    }
}
