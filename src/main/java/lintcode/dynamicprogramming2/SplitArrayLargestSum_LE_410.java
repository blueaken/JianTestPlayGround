package lintcode.dynamicprogramming2;

public class SplitArrayLargestSum_LE_410 {
    /*
        - gut feeling is dp
        - ref 花花 https://www.youtube.com/watch?v=_k-Jb4b7b_0 & Huifeng Guan https://www.youtube.com/watch?v=-F2ysRiSTvk
        - dp[i][j]: i - number of groups, j - number of elements involved, from start of array
        - dp[1][j] = sum(0 ... j), when only 1 group, the ans is just sum every element invloved
        - dp[i][j] = min{max(dp[i-1][k], sum(k+1 ... j))}, 0 <= k < j, basically try every cutting point and find the minimum largest sum
        - Huifeng Guan讲得思路更清楚，但不做讲义；花花的讲义做得好。
        - Time is O(mn^2), Space is O(mn), will TLE for sure.
        - try Binary Search later
    */
    public int splitArray(int[] nums, int m) {
        int[][] dp = new int[m+1][nums.length];
        //init prefix sum array
        int[] ps = new int[nums.length];
        ps[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ps[i] = ps[i-1] + nums[i];
        }

        //init
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < nums.length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                if (i == 1) {
                    dp[1][j] = ps[j];
                }
            }
        }

        for (int i = 2; i <= m; i++) {
            //j need to be at least i elements to split
            for (int j = i-1; j < nums.length; j++) {
                for (int k = 0; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i-1][k], (ps[j] - ps[k])));
                }
            }
        }
        return dp[m][nums.length-1];
    }

    public static void main(String[] args) {
        SplitArrayLargestSum_LE_410 solution = new SplitArrayLargestSum_LE_410();
        int[] nums = {7,2,5,10,8};
        int m = 2;
        //18
        System.out.println(solution.splitArray(nums, m));
    }
}
